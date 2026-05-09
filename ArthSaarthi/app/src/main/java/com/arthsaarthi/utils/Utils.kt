package com.arthsaarthi.utils

import java.text.NumberFormat
import java.util.*

// ── Money Helpers ──────────────────────────────
// All money is stored in PAISE. These convert for display.

fun Long.toRupees(): String {
    val rupees = this / 100
    val formatted = NumberFormat.getInstance(Locale("en", "IN")).format(rupees)
    return "₹$formatted"
}

fun Long.toRupeesWithPaise(): String {
    val rupees = this / 100
    val paise = this % 100
    val formatted = NumberFormat.getInstance(Locale("en", "IN")).format(rupees)
    return if (paise == 0L) "₹$formatted"
    else "₹$formatted.${paise.toString().padStart(2, '0')}"
}

fun Double.rupeesToPaise(): Long = (this * 100).toLong()
fun String.rupeesToPaise(): Long = this.replace(",", "").toDoubleOrNull()?.rupeesToPaise() ?: 0L
fun generateId(): String = UUID.randomUUID().toString()

fun getStartOfMonth(): Long {
    val cal = Calendar.getInstance()
    cal.set(Calendar.DAY_OF_MONTH, 1)
    cal.set(Calendar.HOUR_OF_DAY, 0)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
    return cal.timeInMillis
}

fun Long.toReadableDate(): String {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this
    val months = listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
    return "${cal.get(Calendar.DAY_OF_MONTH)} ${months[cal.get(Calendar.MONTH)]} ${cal.get(Calendar.YEAR)}"
}

// ── Indian Expense Categories ──────────────────

data class ExpenseCategory(val name: String, val emoji: String)

val EXPENSE_CATEGORIES = listOf(
    ExpenseCategory("Groceries", "🛒"),
    ExpenseCategory("Petrol/Diesel", "⛽"),
    ExpenseCategory("Restaurant", "🍽️"),
    ExpenseCategory("Vegetables", "🥦"),
    ExpenseCategory("Electricity", "💡"),
    ExpenseCategory("Mobile Recharge", "📱"),
    ExpenseCategory("EMI", "🏦"),
    ExpenseCategory("Rent", "🏠"),
    ExpenseCategory("School Fees", "📚"),
    ExpenseCategory("Doctor", "🏥"),
    ExpenseCategory("Medicines", "💊"),
    ExpenseCategory("Milk", "🥛"),
    ExpenseCategory("LPG Cylinder", "🔵"),
    ExpenseCategory("Auto/Cab", "🚗"),
    ExpenseCategory("Train/Bus", "🚌"),
    ExpenseCategory("Clothes", "👕"),
    ExpenseCategory("Pooja/Religious", "🪔"),
    ExpenseCategory("Entertainment", "🎬"),
    ExpenseCategory("Gym/Health", "💪"),
    ExpenseCategory("Vegetables/Mandi", "🌿"),
    ExpenseCategory("DTH/Internet", "📡"),
    ExpenseCategory("Wedding/Function", "💍"),
    ExpenseCategory("Agriculture", "🌾"),
    ExpenseCategory("Other", "📦")
)

val INCOME_CATEGORIES = listOf(
    ExpenseCategory("Salary", "💰"),
    ExpenseCategory("Freelance", "💻"),
    ExpenseCategory("Business", "🏪"),
    ExpenseCategory("Farm Income", "🌾"),
    ExpenseCategory("Rental Income", "🏠"),
    ExpenseCategory("Investment Return", "📈"),
    ExpenseCategory("PM-KISAN", "🏛️"),
    ExpenseCategory("Gift/Bonus", "🎁"),
    ExpenseCategory("Other Income", "💵")
)

val PAYMENT_MODES = listOf("Cash", "UPI", "Card", "Net Banking", "Cheque")

// ── Indian States ──────────────────────────────
val INDIAN_STATES = listOf(
    "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
    "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
    "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
    "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
    "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
    "Uttar Pradesh", "Uttarakhand", "West Bengal",
    "Delhi", "Jammu & Kashmir", "Ladakh"
)

// ── Government Schemes ─────────────────────────
data class GovtScheme(
    val id: String,
    val name: String,
    val nameHindi: String,
    val benefit: String,
    val forOccupation: List<String>,
    val documents: List<String>,
    val applyAt: String
)

val GOVT_SCHEMES = listOf(
    GovtScheme("pm_kisan", "PM-KISAN", "पीएम किसान",
        "₹6,000/year (3 installments of ₹2,000)",
        listOf("FARMER"),
        listOf("Aadhaar Card", "Bank Passbook", "Land Records (7/12 Utara)"),
        "pmkisan.gov.in"),
    GovtScheme("pm_mudra", "PM Mudra Loan", "पीएम मुद्रा लोन",
        "Loan up to ₹10 Lakhs for small business",
        listOf("SELF_EMPLOYED"),
        listOf("Aadhaar", "PAN", "Business proof", "Bank statement 6 months"),
        "mudra.org.in"),
    GovtScheme("pm_jjby", "PM Jeevan Jyoti Bima", "पीएम जीवन ज्योति बीमा",
        "₹2 Lakh life insurance at ₹436/year",
        listOf("SALARIED", "SELF_EMPLOYED", "FARMER", "GIG"),
        listOf("Aadhaar", "Bank account linked to Aadhaar"),
        "jansuraksha.gov.in"),
    GovtScheme("pm_sby", "PM Suraksha Bima", "पीएम सुरक्षा बीमा",
        "₹2 Lakh accident cover at ₹20/year",
        listOf("SALARIED", "SELF_EMPLOYED", "FARMER", "GIG"),
        listOf("Aadhaar", "Bank account"),
        "jansuraksha.gov.in"),
    GovtScheme("apy", "Atal Pension Yojana", "अटल पेंशन योजना",
        "Guaranteed pension ₹1,000 to ₹5,000/month after 60",
        listOf("GIG", "SELF_EMPLOYED", "FARMER"),
        listOf("Aadhaar", "Bank account", "Mobile number"),
        "npscra.nsdl.co.in"),
    GovtScheme("sukanya", "Sukanya Samriddhi Yojana", "सुकन्या समृद्धि योजना",
        "8.2% interest p.a. for girl child education/marriage",
        listOf("SALARIED", "SELF_EMPLOYED", "FARMER"),
        listOf("Girl child birth certificate", "Guardian Aadhaar", "PAN"),
        "indiapost.gov.in"),
    GovtScheme("pmay", "PM Awas Yojana", "पीएम आवास योजना",
        "Subsidy up to ₹2.67 Lakh on home loan",
        listOf("SALARIED", "SELF_EMPLOYED"),
        listOf("Aadhaar", "Income certificate", "No pucca house declaration"),
        "pmaymis.gov.in"),
    GovtScheme("ayushman", "Ayushman Bharat", "आयुष्मान भारत",
        "₹5 Lakh health insurance per family per year",
        listOf("FARMER", "GIG", "HOMEMAKER"),
        listOf("Aadhaar", "Ration card", "SECC data verification"),
        "pmjay.gov.in")
)
