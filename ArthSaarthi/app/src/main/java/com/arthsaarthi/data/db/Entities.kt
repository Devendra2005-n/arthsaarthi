package com.arthsaarthi.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// ══════════════════════════════════════════
// GOLDEN RULE: All money stored in PAISE (Long)
// ₹500 = 50000L   NEVER use Float or Double for money
// ══════════════════════════════════════════

@Entity(tableName = "user_profiles")
data class UserProfile(
    @PrimaryKey
    val id: String = "default_user",
    val name: String = "",
    val incomeType: String = "SALARIED",
    // SALARIED, SELF_EMPLOYED, FARMER, GIG, PENSIONER, HOMEMAKER
    val monthlyIncomePaise: Long = 0L,
    val cityTier: String = "TIER2",
    // METRO, TIER1, TIER2, TIER3, RURAL
    val state: String = "Maharashtra",
    val preferredLanguage: String = "en",
    val isOnboardingDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val amountPaise: Long,
    val type: String,
    // EXPENSE or INCOME
    val category: String,
    val paymentMode: String = "CASH",
    // CASH, UPI, CARD, NEFT
    val merchantName: String = "",
    val note: String = "",
    val dateMillis: Long = System.currentTimeMillis(),
    val source: String = "MANUAL",
    // MANUAL, SMS_AUTO, VOICE
    val isVerified: Boolean = true,
    val isDeleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "investments")
data class Investment(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val type: String,
    // SIP, FD, PPF, GOLD, EPF, NPS, STOCKS, RD
    val name: String,
    val investedAmountPaise: Long,
    val currentValuePaise: Long,
    val interestRate: Double = 0.0,
    val startDateMillis: Long = System.currentTimeMillis(),
    val maturityDateMillis: Long = 0L,
    val sipDayOfMonth: Int = 0,
    val bankName: String = "",
    val notes: String = "",
    val lastUpdatedMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val name: String,
    val goalType: String,
    // MARRIAGE, HOME, EDUCATION, EMERGENCY, VEHICLE, RETIREMENT
    val targetAmountPaise: Long,
    val savedAmountPaise: Long = 0L,
    val deadlineMillis: Long,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "loans")
data class Loan(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val loanType: String,
    // HOME, CAR, PERSONAL, EDUCATION, GOLD, TWOWHEELER
    val bankName: String,
    val principalAmountPaise: Long,
    val emiAmountPaise: Long,
    val interestRate: Double,
    val startDateMillis: Long,
    val tenureMonths: Int,
    val remainingEmiCount: Int,
    val notes: String = ""
)

@Entity(tableName = "chit_funds")
data class ChitFund(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val organizerName: String,
    val totalAmountPaise: Long,
    val monthlyInstalmentPaise: Long,
    val durationMonths: Int,
    val startDateMillis: Long,
    val prizeReceivedPaise: Long = 0L,
    val isActive: Boolean = true,
    val notes: String = ""
)

@Entity(tableName = "gold_assets")
data class GoldAsset(
    @PrimaryKey
    val id: String,
    val userId: String = "default_user",
    val weightGrams: Double,
    val purity: String = "K22",
    // K24, K22, K18
    val purchasePricePerGramPaise: Long,
    val purchaseDateMillis: Long,
    val storageType: String = "PHYSICAL",
    // PHYSICAL, SGB, ETF
    val notes: String = ""
)
