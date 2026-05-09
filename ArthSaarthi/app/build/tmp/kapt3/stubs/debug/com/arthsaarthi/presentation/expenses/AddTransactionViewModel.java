package com.arthsaarthi.presentation.expenses;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.Transaction;
import com.arthsaarthi.data.db.TransactionDao;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/arthsaarthi/presentation/expenses/AddTransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionDao", "Lcom/arthsaarthi/data/db/TransactionDao;", "(Lcom/arthsaarthi/data/db/TransactionDao;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/arthsaarthi/presentation/expenses/AddTransactionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "appendDigit", "", "digit", "", "backspace", "save", "setAmountFromPaise", "paise", "", "setCategory", "cat", "setMerchant", "v", "setNote", "setPaymentMode", "mode", "setType", "type", "app_debug"})
public final class AddTransactionViewModel extends androidx.lifecycle.ViewModel {
    private final com.arthsaarthi.data.db.TransactionDao transactionDao = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.arthsaarthi.presentation.expenses.AddTransactionUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.expenses.AddTransactionUiState> uiState = null;
    
    @javax.inject.Inject
    public AddTransactionViewModel(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.TransactionDao transactionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.expenses.AddTransactionUiState> getUiState() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull
    java.lang.String cat) {
    }
    
    public final void setPaymentMode(@org.jetbrains.annotations.NotNull
    java.lang.String mode) {
    }
    
    public final void setMerchant(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull
    java.lang.String v) {
    }
    
    public final void appendDigit(@org.jetbrains.annotations.NotNull
    java.lang.String digit) {
    }
    
    public final void backspace() {
    }
    
    public final void setAmountFromPaise(long paise) {
    }
    
    public final void save() {
    }
}