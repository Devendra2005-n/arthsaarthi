package com.arthsaarthi.presentation.tax;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/arthsaarthi/presentation/tax/TaxViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/arthsaarthi/presentation/tax/TaxUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "calcNewRegimeTax", "", "income", "calcOldRegimeTax", "calculate", "", "setEpfContrib", "v", "", "setGrossIncome", "setHealthInsurance", "setHomeLoanInterest", "setHraReceived", "setIsMetro", "", "setNpsContrib", "setOther80C", "setRentPaid", "app_debug"})
public final class TaxViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<com.arthsaarthi.presentation.tax.TaxUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.tax.TaxUiState> uiState = null;
    
    @javax.inject.Inject
    public TaxViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.tax.TaxUiState> getUiState() {
        return null;
    }
    
    public final void setGrossIncome(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setHraReceived(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setRentPaid(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setEpfContrib(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setOther80C(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setHealthInsurance(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setNpsContrib(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setHomeLoanInterest(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setIsMetro(boolean v) {
    }
    
    public final void calculate() {
    }
    
    private final long calcOldRegimeTax(long income) {
        return 0L;
    }
    
    private final long calcNewRegimeTax(long income) {
        return 0L;
    }
}