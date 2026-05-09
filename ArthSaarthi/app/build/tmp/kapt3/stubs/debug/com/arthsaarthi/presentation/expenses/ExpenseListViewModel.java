package com.arthsaarthi.presentation.expenses;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.Transaction;
import com.arthsaarthi.data.db.TransactionDao;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/arthsaarthi/presentation/expenses/ExpenseListViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionDao", "Lcom/arthsaarthi/data/db/TransactionDao;", "(Lcom/arthsaarthi/data/db/TransactionDao;)V", "startOfMonth", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/arthsaarthi/presentation/expenses/ExpenseListUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "delete", "", "id", "", "app_debug"})
public final class ExpenseListViewModel extends androidx.lifecycle.ViewModel {
    private final com.arthsaarthi.data.db.TransactionDao transactionDao = null;
    private final long startOfMonth = 0L;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.expenses.ExpenseListUiState> uiState = null;
    
    @javax.inject.Inject
    public ExpenseListViewModel(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.TransactionDao transactionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.expenses.ExpenseListUiState> getUiState() {
        return null;
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
}