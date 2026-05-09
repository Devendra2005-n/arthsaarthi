package com.arthsaarthi.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.arthsaarthi.data.db.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ArthSaarthiDatabase {
        return Room.databaseBuilder(
            context,
            ArthSaarthiDatabase::class.java,
            "arthsaarthi_db"
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    @Provides fun provideTransactionDao(db: ArthSaarthiDatabase): TransactionDao = db.transactionDao()
    @Provides fun provideUserProfileDao(db: ArthSaarthiDatabase): UserProfileDao = db.userProfileDao()
    @Provides fun provideInvestmentDao(db: ArthSaarthiDatabase): InvestmentDao = db.investmentDao()
    @Provides fun provideGoalDao(db: ArthSaarthiDatabase): GoalDao = db.goalDao()
    @Provides fun provideLoanDao(db: ArthSaarthiDatabase): LoanDao = db.loanDao()
    @Provides fun provideChitFundDao(db: ArthSaarthiDatabase): ChitFundDao = db.chitFundDao()
    @Provides fun provideGoldAssetDao(db: ArthSaarthiDatabase): GoldAssetDao = db.goldAssetDao()
}
