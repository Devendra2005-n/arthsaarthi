package com.arthsaarthi.data.db;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J&\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\'J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/arthsaarthi/data/db/InvestmentDao;", "", "delete", "", "investment", "Lcom/arthsaarthi/data/db/Investment;", "(Lcom/arthsaarthi/data/db/Investment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllInvestments", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "getByType", "type", "getTotalCurrentValue", "", "getTotalInvested", "insert", "update", "app_debug"})
public abstract interface InvestmentDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Investment investment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Investment investment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Investment investment, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM investments WHERE userId = :userId ORDER BY type ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.Investment>> getAllInvestments(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM investments WHERE userId = :userId AND type = :type")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.arthsaarthi.data.db.Investment>> getByType(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COALESCE(SUM(currentValuePaise), 0) FROM investments WHERE userId = :userId")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Long> getTotalCurrentValue(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COALESCE(SUM(investedAmountPaise), 0) FROM investments WHERE userId = :userId")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Long> getTotalInvested(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}