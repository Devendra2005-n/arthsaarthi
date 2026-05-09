package com.arthsaarthi.presentation.home;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.*;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/arthsaarthi/presentation/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionDao", "Lcom/arthsaarthi/data/db/TransactionDao;", "userProfileDao", "Lcom/arthsaarthi/data/db/UserProfileDao;", "investmentDao", "Lcom/arthsaarthi/data/db/InvestmentDao;", "loanDao", "Lcom/arthsaarthi/data/db/LoanDao;", "(Lcom/arthsaarthi/data/db/TransactionDao;Lcom/arthsaarthi/data/db/UserProfileDao;Lcom/arthsaarthi/data/db/InvestmentDao;Lcom/arthsaarthi/data/db/LoanDao;)V", "startOfMonth", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/arthsaarthi/presentation/home/HomeUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.arthsaarthi.data.db.TransactionDao transactionDao = null;
    private final com.arthsaarthi.data.db.UserProfileDao userProfileDao = null;
    private final com.arthsaarthi.data.db.InvestmentDao investmentDao = null;
    private final com.arthsaarthi.data.db.LoanDao loanDao = null;
    private final long startOfMonth = 0L;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.home.HomeUiState> uiState = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.UserProfileDao userProfileDao, @org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.InvestmentDao investmentDao, @org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.LoanDao loanDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.home.HomeUiState> getUiState() {
        return null;
    }
}