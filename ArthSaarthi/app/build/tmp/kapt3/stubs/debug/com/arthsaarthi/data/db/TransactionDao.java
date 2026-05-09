package com.arthsaarthi.data.db;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\'J\u001b\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\tH\'J&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\'J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\'J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\'J&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/arthsaarthi/data/db/TransactionDao;", "", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/arthsaarthi/data/db/Transaction;", "userId", "", "getCount", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentTransactions", "limit", "getThisMonthExpenses", "startOfMonth", "", "getThisMonthTotalIncome", "getThisMonthTotalSpend", "getTopCategories", "Lcom/arthsaarthi/data/db/CategoryTotal;", "insert", "", "transaction", "(Lcom/arthsaarthi/data/db/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "softDelete", "id", "update", "app_debug"})
public abstract interface TransactionDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Transaction transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Transaction transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND isDeleted = 0 ORDER BY dateMillis DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.Transaction>> getAllTransactions(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND isDeleted = 0 ORDER BY dateMillis DESC LIMIT :limit")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.Transaction>> getRecentTransactions(@org.jetbrains.annotations.NotNull
    java.lang.String userId, int limit);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND type = \'EXPENSE\' AND isDeleted = 0 AND dateMillis >= :startOfMonth ORDER BY dateMillis DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.Transaction>> getThisMonthExpenses(@org.jetbrains.annotations.NotNull
    java.lang.String userId, long startOfMonth);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = :userId AND type = \'EXPENSE\' AND isDeleted = 0 AND dateMillis >= :startOfMonth")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Long> getThisMonthTotalSpend(@org.jetbrains.annotations.NotNull
    java.lang.String userId, long startOfMonth);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COALESCE(SUM(amountPaise), 0) FROM transactions WHERE userId = :userId AND type = \'INCOME\' AND isDeleted = 0 AND dateMillis >= :startOfMonth")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Long> getThisMonthTotalIncome(@org.jetbrains.annotations.NotNull
    java.lang.String userId, long startOfMonth);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT category, SUM(amountPaise) as total FROM transactions WHERE userId = :userId AND type = \'EXPENSE\' AND isDeleted = 0 AND dateMillis >= :startOfMonth GROUP BY category ORDER BY total DESC LIMIT 5")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.CategoryTotal>> getTopCategories(@org.jetbrains.annotations.NotNull
    java.lang.String userId, long startOfMonth);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "UPDATE transactions SET isDeleted = 1 WHERE id = :id")
    public abstract java.lang.Object softDelete(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT COUNT(*) FROM transactions WHERE userId = :userId AND isDeleted = 0")
    public abstract java.lang.Object getCount(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}