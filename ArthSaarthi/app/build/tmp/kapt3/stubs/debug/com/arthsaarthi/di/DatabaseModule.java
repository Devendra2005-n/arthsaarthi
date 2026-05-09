package com.arthsaarthi.di;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import com.arthsaarthi.data.db.*;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/arthsaarthi/di/DatabaseModule;", "", "()V", "provideChitFundDao", "Lcom/arthsaarthi/data/db/ChitFundDao;", "db", "Lcom/arthsaarthi/data/db/ArthSaarthiDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "provideGoalDao", "Lcom/arthsaarthi/data/db/GoalDao;", "provideGoldAssetDao", "Lcom/arthsaarthi/data/db/GoldAssetDao;", "provideInvestmentDao", "Lcom/arthsaarthi/data/db/InvestmentDao;", "provideLoanDao", "Lcom/arthsaarthi/data/db/LoanDao;", "provideTransactionDao", "Lcom/arthsaarthi/data/db/TransactionDao;", "provideUserProfileDao", "Lcom/arthsaarthi/data/db/UserProfileDao;", "app_debug"})
@dagger.Module
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.arthsaarthi.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.arthsaarthi.data.db.ArthSaarthiDatabase provideDatabase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.TransactionDao provideTransactionDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.UserProfileDao provideUserProfileDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.InvestmentDao provideInvestmentDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.GoalDao provideGoalDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.LoanDao provideLoanDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.ChitFundDao provideChitFundDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.arthsaarthi.data.db.GoldAssetDao provideGoldAssetDao(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.ArthSaarthiDatabase db) {
        return null;
    }
}