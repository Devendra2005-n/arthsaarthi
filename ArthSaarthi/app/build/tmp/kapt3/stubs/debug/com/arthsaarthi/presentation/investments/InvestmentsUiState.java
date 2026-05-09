package com.arthsaarthi.presentation.investments;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.Investment;
import com.arthsaarthi.data.db.InvestmentDao;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/arthsaarthi/presentation/investments/InvestmentsUiState;", "", "investments", "", "Lcom/arthsaarthi/data/db/Investment;", "totalInvested", "", "totalCurrentValue", "(Ljava/util/List;JJ)V", "getInvestments", "()Ljava/util/List;", "getTotalCurrentValue", "()J", "getTotalInvested", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class InvestmentsUiState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.arthsaarthi.data.db.Investment> investments = null;
    private final long totalInvested = 0L;
    private final long totalCurrentValue = 0L;
    
    @org.jetbrains.annotations.NotNull
    public final com.arthsaarthi.presentation.investments.InvestmentsUiState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.arthsaarthi.data.db.Investment> investments, long totalInvested, long totalCurrentValue) {
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
    
    public InvestmentsUiState() {
        super();
    }
    
    public InvestmentsUiState(@org.jetbrains.annotations.NotNull
    java.util.List<com.arthsaarthi.data.db.Investment> investments, long totalInvested, long totalCurrentValue) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.arthsaarthi.data.db.Investment> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.arthsaarthi.data.db.Investment> getInvestments() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getTotalInvested() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getTotalCurrentValue() {
        return 0L;
    }
}