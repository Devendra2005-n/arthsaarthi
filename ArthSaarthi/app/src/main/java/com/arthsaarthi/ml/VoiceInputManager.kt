package com.arthsaarthi.ml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer

class VoiceInputManager(private val context: Context) {

    private var recognizer: SpeechRecognizer? = null

    fun startListening(
        languageCode: String = "hi-IN",
        onResult: (String) -> Unit,
        onError: () -> Unit
    ) {
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            onError()
            return
        }

        recognizer?.destroy()
        recognizer = SpeechRecognizer.createSpeechRecognizer(context)
        recognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onResults(results: Bundle) {
                val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                val text = matches?.firstOrNull() ?: ""
                if (text.isNotEmpty()) onResult(text) else onError()
            }
            override fun onError(error: Int) { onError() }
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCode)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
            putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 1000L)
        }
        recognizer?.startListening(intent)
    }

    fun stop() {
        recognizer?.stopListening()
    }

    fun destroy() {
        recognizer?.destroy()
        recognizer = null
    }

    // Language code map for 12 Indian languages
    companion object {
        fun getLanguageCode(langCode: String): String = when (langCode) {
            "hi" -> "hi-IN"
            "mr" -> "mr-IN"
            "ta" -> "ta-IN"
            "te" -> "te-IN"
            "kn" -> "kn-IN"
            "bn" -> "bn-IN"
            "gu" -> "gu-IN"
            "pa" -> "pa-IN"
            "ml" -> "ml-IN"
            "or" -> "or-IN"
            "as" -> "as-IN"
            "ur" -> "ur-IN"
            else -> "en-IN"
        }
    }
}

// ── Voice Command Parser ─────────────────────
// Parses Hindi/regional voice commands into transaction data
// No AI needed — pure rule-based logic

data class ParsedVoiceCommand(
    val amountPaise: Long?,
    val category: String?,
    val paymentMode: String?,
    val isIncome: Boolean = false,
    val confidence: Float = 0f
)

object VoiceCommandParser {

    fun parse(text: String, language: String = "hi"): ParsedVoiceCommand {
        val lower = text.lowercase().trim()

        val amount = extractAmount(lower)
        val category = extractCategory(lower)
        val paymentMode = extractPaymentMode(lower)
        val isIncome = isIncomeTransaction(lower)

        val confidence = when {
            amount != null && category != null -> 0.95f
            amount != null -> 0.70f
            else -> 0.30f
        }

        return ParsedVoiceCommand(
            amountPaise = amount,
            category = category,
            paymentMode = paymentMode,
            isIncome = isIncome,
            confidence = confidence
        )
    }

    private fun extractAmount(text: String): Long? {
        // Try digit extraction first: "500", "1500", "2,000"
        val digitPattern = Regex("(\\d[\\d,]*(?:\\.\\d{1,2})?)")
        val digitMatch = digitPattern.find(text)
        if (digitMatch != null) {
            val numStr = digitMatch.value.replace(",", "")
            val num = numStr.toDoubleOrNull() ?: return null

            // Check for multiplier words after the number
            val afterNum = text.substring(digitMatch.range.last + 1).trim()
            return when {
                afterNum.startsWith("lakh") || afterNum.startsWith("lak") -> (num * 100000 * 100).toLong()
                afterNum.startsWith("hazaar") || afterNum.startsWith("hazar") || afterNum.startsWith("thousand") -> (num * 1000 * 100).toLong()
                afterNum.startsWith("sau") || afterNum.startsWith("hundred") -> (num * 100 * 100).toLong()
                else -> (num * 100).toLong() // direct rupees to paise
            }
        }

        // Hindi word numbers
        val wordAmounts = mapOf(
            "ek sau" to 100L, "do sau" to 200L, "teen sau" to 300L,
            "char sau" to 400L, "paanch sau" to 500L, "chhe sau" to 600L,
            "saat sau" to 700L, "aath sau" to 800L, "nau sau" to 900L,
            "ek hazaar" to 1000L, "do hazaar" to 2000L, "paanch hazaar" to 5000L,
            "das hazaar" to 10000L, "bees hazaar" to 20000L, "pachas hazaar" to 50000L,
            "ek lakh" to 100000L, "do lakh" to 200000L, "paanch lakh" to 500000L
        )
        for ((words, amount) in wordAmounts) {
            if (text.contains(words)) return amount * 100 // convert to paise
        }

        return null
    }

    private fun extractCategory(text: String): String? {
        return when {
            text.containsAny("petrol", "diesel", "tel", "petrol pump", "fuel") -> "Petrol/Diesel"
            text.containsAny("khana", "khaana", "food", "restaurant", "dhaba", "hotel", "zomato", "swiggy", "lunch", "dinner", "nashta", "breakfast") -> "Restaurant"
            text.containsAny("sabzi", "vegetable", "sabzee", "mandi", "bhaji") -> "Vegetables"
            text.containsAny("kirana", "grocery", "ration", "dukan", "shop", "grocer") -> "Groceries"
            text.containsAny("bijli", "electricity", "light bill", "current bill", "msedcl", "bescom") -> "Electricity"
            text.containsAny("mobile", "recharge", "jio", "airtel", "vi ", "phone", "sim") -> "Mobile Recharge"
            text.containsAny("emi", "loan", "kist", "installment", "equated") -> "EMI"
            text.containsAny("rent", "kiraya", "house rent", "ghar ka kiraya") -> "Rent"
            text.containsAny("school", "college", "fees", "tuition", "padhai", "coaching") -> "School Fees"
            text.containsAny("doctor", "hospital", "dawai", "medicine", "dawa", "clinic", "medical") -> "Doctor"
            text.containsAny("milk", "dudh", "doodh", "amul") -> "Milk"
            text.containsAny("gas", "lpg", "cylinder", "cooking gas", "gas cylinder") -> "LPG Cylinder"
            text.containsAny("auto", "cab", "ola", "uber", "rapido", "rickshaw") -> "Auto/Cab"
            text.containsAny("train", "bus", "metro", "railway", "ticket") -> "Train/Bus"
            text.containsAny("kapda", "clothes", "shirt", "pant", "dress") -> "Clothes"
            text.containsAny("pooja", "puja", "mandir", "temple", "religious", "prasad") -> "Pooja/Religious"
            text.containsAny("salary", "tankhwah", "payment received", "mila") -> "Salary"
            text.containsAny("freelance", "project", "work", "kaam ka paisa") -> "Freelance"
            text.containsAny("farm", "khet", "fasal", "crop", "kheti") -> "Farm Income"
            text.containsAny("sip", "mutual fund", "investment", "invest") -> "SIP/Investment"
            text.containsAny("dth", "tata play", "dish", "tv", "internet", "wifi", "broadband") -> "DTH/Internet"
            text.containsAny("shaadi", "wedding", "function", "party") -> "Wedding/Function"
            else -> null
        }
    }

    private fun extractPaymentMode(text: String): String? = when {
        text.containsAny("cash", "nakd", "naqd", "nakit", "haath se") -> "Cash"
        text.containsAny("upi", "gpay", "google pay", "phonepay", "phonepe", "paytm", "bhim") -> "UPI"
        text.containsAny("card", "debit", "credit", "swipe") -> "Card"
        text.containsAny("net banking", "neft", "imps", "rtgs", "bank transfer") -> "Net Banking"
        else -> null
    }

    private fun isIncomeTransaction(text: String): Boolean =
        text.containsAny("mila", "received", "aaya", "credit", "income", "kamai", "tankhwah", "salary", "payment aaya")

    private fun String.containsAny(vararg words: String) = words.any { this.contains(it) }
}
