package com.arthsaarthi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        UserProfile::class,
        Transaction::class,
        Investment::class,
        Goal::class,
        Loan::class,
        ChitFund::class,
        GoldAsset::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ArthSaarthiDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun investmentDao(): InvestmentDao
    abstract fun goalDao(): GoalDao
    abstract fun loanDao(): LoanDao
    abstract fun chitFundDao(): ChitFundDao
    abstract fun goldAssetDao(): GoldAssetDao
}
