package com.arthsaarthi.ml

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        messages?.forEach { sms ->
            val sender = sms.originatingAddress ?: ""
            val body = sms.messageBody ?: ""

            if (isFinancialSms(sender, body)) {
                Log.d("ArthSaarthi", "Financial SMS detected from: $sender")
                val parsed = SmsParser.parse(body)
                if (parsed != null) {
                    Log.d("ArthSaarthi", "Parsed: amount=${parsed.amountPaise}, cat=${parsed.category}")
                    // In production: save to DB and show notification
                    // For MVP: log and let user manually confirm
                }
            }
        }
    }

    private fun isFinancialSms(sender: String, body: String): Boolean {
        val bankSenders = listOf(
            "HDFCBK", "SBIINB", "ICICIB", "AXISBK", "KOTAKB",
            "PNBSMS", "BOIIND", "CANBNK", "UNIONB", "IDBIBK",
            "PAYTMB", "PHONEPE", "GPAY", "BHIMUPI", "YESBNK",
            "INDBNK", "CENTBK", "BARODAB", "MAHABK", "SYNDBK"
        )
        val senderUpper = sender.uppercase()
        val hasFinancialWord = body.contains(Regex("(?i)(debited|credited|Rs\\.?\\s*\\d|₹\\s*\\d|INR\\s*\\d|spent|payment)"))
        return bankSenders.any { senderUpper.contains(it) } || hasFinancialWord
    }
}

data class ParsedSms(
    val amountPaise: Long,
    val type: String,         // EXPENSE or INCOME
    val category: String,
    val merchantName: String
)

object SmsParser {

    private val AMOUNT_PATTERN = Regex("(?:Rs\\.?|INR|₹)\\s*([\\d,]+(?:\\.\\d{1,2})?)", RegexOption.IGNORE_CASE)
    private val IS_DEBIT = Regex("(?i)debited|spent|paid|withdrawn|debit")
    private val IS_CREDIT = Regex("(?i)credited|received|credit|deposit")

    // UPI merchant ID → (display name, category)
    private val UPI_MERCHANTS = mapOf(
        "zomato" to Pair("Zomato", "Restaurant"),
        "swiggy" to Pair("Swiggy", "Restaurant"),
        "ola" to Pair("Ola", "Auto/Cab"),
        "rapido" to Pair("Rapido", "Auto/Cab"),
        "uber" to Pair("Uber", "Auto/Cab"),
        "jio" to Pair("Jio Recharge", "Mobile Recharge"),
        "airtel" to Pair("Airtel", "Mobile Recharge"),
        "vi" to Pair("Vi Recharge", "Mobile Recharge"),
        "amazon" to Pair("Amazon", "Shopping"),
        "flipkart" to Pair("Flipkart", "Shopping"),
        "bigbasket" to Pair("BigBasket", "Groceries"),
        "blinkit" to Pair("Blinkit", "Groceries"),
        "grofers" to Pair("Blinkit", "Groceries"),
        "dmart" to Pair("DMart", "Groceries"),
        "hpcl" to Pair("HPCL Petrol", "Petrol/Diesel"),
        "iocl" to Pair("IOCL Petrol", "Petrol/Diesel"),
        "bpcl" to Pair("BPCL Petrol", "Petrol/Diesel"),
        "msedcl" to Pair("Electricity Bill", "Electricity"),
        "bescom" to Pair("BESCOM Electricity", "Electricity"),
        "tpddl" to Pair("Electricity Bill", "Electricity"),
        "mahadiscom" to Pair("MSEDCL Bill", "Electricity"),
        "netflix" to Pair("Netflix", "Entertainment"),
        "hotstar" to Pair("Disney+ Hotstar", "Entertainment"),
        "spotify" to Pair("Spotify", "Entertainment"),
        "tataplay" to Pair("Tata Play DTH", "DTH/Internet"),
        "apollopharmacy" to Pair("Apollo Pharmacy", "Medicines"),
        "medplus" to Pair("MedPlus", "Medicines"),
        "1mg" to Pair("1mg", "Medicines"),
        "swasthbharat" to Pair("Pharmacy", "Medicines"),
    )

    fun parse(smsBody: String): ParsedSms? {
        val amountMatch = AMOUNT_PATTERN.find(smsBody) ?: return null
        val amountStr = amountMatch.groupValues[1].replace(",", "")
        val amountRs = amountStr.toDoubleOrNull() ?: return null
        val amountPaise = (amountRs * 100).toLong()

        val isDebit = IS_DEBIT.containsMatchIn(smsBody)
        val isCredit = IS_CREDIT.containsMatchIn(smsBody)
        if (!isDebit && !isCredit) return null

        val type = if (isCredit) "INCOME" else "EXPENSE"

        // Try to find merchant from UPI ID in SMS
        val lowerBody = smsBody.lowercase()
        val matchedMerchant = UPI_MERCHANTS.entries.firstOrNull { (key, _) -> lowerBody.contains(key) }

        val merchantName = matchedMerchant?.value?.first ?: extractMerchantFallback(smsBody)
        val category = matchedMerchant?.value?.second ?: guessCategory(smsBody)

        return ParsedSms(
            amountPaise = amountPaise,
            type = type,
            category = category,
            merchantName = merchantName
        )
    }

    private fun extractMerchantFallback(body: String): String {
        val patterns = listOf(
            Regex("(?:Info|at|to|from):\\s*([A-Z][A-Za-z0-9\\s]{2,20})", RegexOption.IGNORE_CASE),
            Regex("(?:paid to|sent to)\\s+([A-Za-z0-9\\s]{2,25})", RegexOption.IGNORE_CASE)
        )
        for (p in patterns) {
            val match = p.find(body)
            if (match != null) return match.groupValues[1].trim()
        }
        return ""
    }

    private fun guessCategory(body: String): String {
        val lower = body.lowercase()
        return when {
            lower.containsAny("petrol", "fuel", "diesel", "hpcl", "iocl", "bpcl") -> "Petrol/Diesel"
            lower.containsAny("grocery", "kirana", "sabzi", "vegetable", "dmart", "bigbasket") -> "Groceries"
            lower.containsAny("restaurant", "food", "hotel", "dhaba", "swiggy", "zomato") -> "Restaurant"
            lower.containsAny("electricity", "bijli", "bescom", "msedcl", "light bill") -> "Electricity"
            lower.containsAny("mobile", "recharge", "jio", "airtel", "vi ", "bsnl") -> "Mobile Recharge"
            lower.containsAny("emi", "loan", "installment", "kist") -> "EMI"
            lower.containsAny("medicine", "pharmacy", "medical", "doctor", "hospital") -> "Medicines"
            lower.containsAny("school", "college", "fees", "education", "tuition") -> "School Fees"
            lower.containsAny("milk", "amul", "mother dairy") -> "Milk"
            lower.containsAny("rent", "house rent") -> "Rent"
            lower.containsAny("salary", "credited") -> "Salary"
            else -> "Other"
        }
    }

    private fun String.containsAny(vararg words: String) = words.any { this.contains(it) }
}
