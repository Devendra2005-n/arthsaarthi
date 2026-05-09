package com.arthsaarthi.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE userId = :userId AND isDeleted = 0 ORDER BY dateMillis DESC")
    fun getAllTransactions(userId: String = "default_user"): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE userId = :userId AND isDeleted = 0 ORDER BY dateMillis DESC LIMIT :limit")
    fun getRecentTransactions(userId: String = "default_user", limit: Int = 10): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE userId = :userId AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= :startOfMonth ORDER BY dateMillis DESC")
    fun getThisMonthExpenses(userId: String = "default_user", startOfMonth: Long): Flow<List<Transaction>>

    @Query("SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = :userId AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= :startOfMonth")
    fun getThisMonthTotalSpend(userId: String = "default_user", startOfMonth: Long): Flow<Long>

    @Query("SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = :userId AND type = 'INCOME' AND isDeleted = 0 AND dateMillis >= :startOfMonth")
    fun getThisMonthTotalIncome(userId: String = "default_user", startOfMonth: Long): Flow<Long>

    @Query("SELECT category, SUM(amountPaise) as total FROM transactions WHERE userId = :userId AND type = 'EXPENSE' AND isDeleted = 0 AND dateMillis >= :startOfMonth GROUP BY category ORDER BY total DESC LIMIT 5")
    fun getTopCategories(userId: String = "default_user", startOfMonth: Long): Flow<List<CategoryTotal>>

    @Query("UPDATE transactions SET isDeleted = 1 WHERE id = :id")
    suspend fun softDelete(id: String)

    @Query("SELECT COUNT(*) FROM transactions WHERE userId = :userId AND isDeleted = 0")
    suspend fun getCount(userId: String = "default_user"): Int
}

data class CategoryTotal(
    val category: String,
    val total: Long
)

@Dao
interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: UserProfile)

    @Update
    suspend fun update(profile: UserProfile)

    @Query("SELECT * FROM user_profiles WHERE id = 'default_user' LIMIT 1")
    fun getProfile(): Flow<UserProfile?>

    @Query("SELECT * FROM user_profiles WHERE id = 'default_user' LIMIT 1")
    suspend fun getProfileOnce(): UserProfile?

    @Query("SELECT isOnboardingDone FROM user_profiles WHERE id = 'default_user' LIMIT 1")
    suspend fun isOnboardingDone(): Boolean?
}

@Dao
interface InvestmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(investment: Investment)

    @Update
    suspend fun update(investment: Investment)

    @Delete
    suspend fun delete(investment: Investment)

    @Query("SELECT * FROM investments WHERE userId = :userId ORDER BY type ASC")
    fun getAllInvestments(userId: String = "default_user"): Flow<List<Investment>>

    @Query("SELECT * FROM investments WHERE userId = :userId AND type = :type")
    fun getByType(userId: String = "default_user", type: String): Flow<List<Investment>>

    @Query("SELECT COALESCE(SUM(currentValuePaise), 0) FROM investments WHERE userId = :userId")
    fun getTotalCurrentValue(userId: String = "default_user"): Flow<Long>

    @Query("SELECT COALESCE(SUM(investedAmountPaise), 0) FROM investments WHERE userId = :userId")
    fun getTotalInvested(userId: String = "default_user"): Flow<Long>
}

@Dao
interface GoalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goal: Goal)

    @Update
    suspend fun update(goal: Goal)

    @Delete
    suspend fun delete(goal: Goal)

    @Query("SELECT * FROM goals WHERE userId = :userId AND isCompleted = 0 ORDER BY deadlineMillis ASC")
    fun getActiveGoals(userId: String = "default_user"): Flow<List<Goal>>
}

@Dao
interface LoanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(loan: Loan)

    @Update
    suspend fun update(loan: Loan)

    @Delete
    suspend fun delete(loan: Loan)

    @Query("SELECT * FROM loans WHERE userId = :userId ORDER BY emiAmountPaise DESC")
    fun getAllLoans(userId: String = "default_user"): Flow<List<Loan>>

    @Query("SELECT COALESCE(SUM(emiAmountPaise), 0) FROM loans WHERE userId = :userId")
    fun getTotalEmiPerMonth(userId: String = "default_user"): Flow<Long>
}

@Dao
interface ChitFundDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(chitFund: ChitFund)

    @Update
    suspend fun update(chitFund: ChitFund)

    @Query("SELECT * FROM chit_funds WHERE userId = :userId AND isActive = 1")
    fun getActiveChits(userId: String = "default_user"): Flow<List<ChitFund>>
}

@Dao
interface GoldAssetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(goldAsset: GoldAsset)

    @Update
    suspend fun update(goldAsset: GoldAsset)

    @Delete
    suspend fun delete(goldAsset: GoldAsset)

    @Query("SELECT * FROM gold_assets WHERE userId = :userId")
    fun getAllGold(userId: String = "default_user"): Flow<List<GoldAsset>>
}
