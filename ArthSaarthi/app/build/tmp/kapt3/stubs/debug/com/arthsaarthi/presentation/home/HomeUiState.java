package com.arthsaarthi.presentation.home;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.*;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\u000b\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u001b\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\u000bH\u00c6\u0003Jq\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\u000bH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/arthsaarthi/presentation/home/HomeUiState;", "", "userName", "", "thisMonthSpend", "", "thisMonthIncome", "totalAssets", "totalLoans", "netWorth", "recentTransactions", "", "Lcom/arthsaarthi/data/db/Transaction;", "topCategories", "Lkotlin/Pair;", "(Ljava/lang/String;JJJJJLjava/util/List;Ljava/util/List;)V", "getNetWorth", "()J", "getRecentTransactions", "()Ljava/util/List;", "getThisMonthIncome", "getThisMonthSpend", "getTopCategories", "getTotalAssets", "getTotalLoans", "getUserName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class HomeUiState {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String userName = null;
    private final long thisMonthSpend = 0L;
    private final long thisMonthIncome = 0L;
    private final long totalAssets = 0L;
    private final long totalLoans = 0L;
    private final long netWorth = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.arthsaarthi.data.db.Transaction> recentTransactions = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> topCategories = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.arthsaarthi.presentation.home.HomeUiState copy(@org.jetbrains.annotations.NotNull
    java.lang.String userName, long thisMonthSpend, long thisMonthIncome, long totalAssets, long totalLoans, long netWorth, @org.jetbrains.annotations.NotNull
    java.util.List<com.arthsaarthi.data.db.Transaction> recentTransactions, @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> topCategories) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public HomeUiState() {
        super();
    }
    
    public HomeUiState(@org.jetbrains.annotations.NotNull
    java.lang.String userName, long thisMonthSpend, long thisMonthIncome, long totalAssets, long totalLoans, long netWorth, @org.jetbrains.annotations.NotNull
    java.util.List<com.arthsaarthi.data.db.Transaction> recentTransactions, @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> topCategories) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getThisMonthSpend() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getThisMonthIncome() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getTotalAssets() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getTotalLoans() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long getNetWorth() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.arthsaarthi.data.db.Transaction> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.arthsaarthi.data.db.Transaction> getRecentTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> getTopCategories() {
        return null;
    }
}