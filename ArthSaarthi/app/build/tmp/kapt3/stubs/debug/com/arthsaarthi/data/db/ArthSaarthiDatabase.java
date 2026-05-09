package com.arthsaarthi.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {com.arthsaarthi.data.db.UserProfile.class, com.arthsaarthi.data.db.Transaction.class, com.arthsaarthi.data.db.Investment.class, com.arthsaarthi.data.db.Goal.class, com.arthsaarthi.data.db.Loan.class, com.arthsaarthi.data.db.ChitFund.class, com.arthsaarthi.data.db.GoldAsset.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/arthsaarthi/data/db/ArthSaarthiDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chitFundDao", "Lcom/arthsaarthi/data/db/ChitFundDao;", "goalDao", "Lcom/arthsaarthi/data/db/GoalDao;", "goldAssetDao", "Lcom/arthsaarthi/data/db/GoldAssetDao;", "investmentDao", "Lcom/arthsaarthi/data/db/InvestmentDao;", "loanDao", "Lcom/arthsaarthi/data/db/LoanDao;", "transactionDao", "Lcom/arthsaarthi/data/db/TransactionDao;", "userProfileDao", "Lcom/arthsaarthi/data/db/UserProfileDao;", "app_debug"})
public abstract class ArthSaarthiDatabase extends androidx.room.RoomDatabase {
    
    public ArthSaarthiDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.UserProfileDao userProfileDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.InvestmentDao investmentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.GoalDao goalDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.LoanDao loanDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.ChitFundDao chitFundDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.arthsaarthi.data.db.GoldAssetDao goldAssetDao();
}