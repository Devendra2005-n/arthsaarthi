package com.arthsaarthi.presentation.onboarding;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.UserProfile;
import com.arthsaarthi.data.db.UserProfileDao;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/arthsaarthi/presentation/onboarding/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "userProfileDao", "Lcom/arthsaarthi/data/db/UserProfileDao;", "(Lcom/arthsaarthi/data/db/UserProfileDao;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/arthsaarthi/presentation/onboarding/OnboardingUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkOnboardingStatus", "", "completeOnboarding", "nextStep", "setCityTier", "tier", "", "setIncomeType", "type", "setLanguage", "lang", "setName", "name", "app_debug"})
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    private final com.arthsaarthi.data.db.UserProfileDao userProfileDao = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.arthsaarthi.presentation.onboarding.OnboardingUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.onboarding.OnboardingUiState> uiState = null;
    
    @javax.inject.Inject
    public OnboardingViewModel(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.UserProfileDao userProfileDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.onboarding.OnboardingUiState> getUiState() {
        return null;
    }
    
    private final void checkOnboardingStatus() {
    }
    
    public final void nextStep() {
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String lang) {
    }
    
    public final void setIncomeType(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    public final void setCityTier(@org.jetbrains.annotations.NotNull
    java.lang.String tier) {
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void completeOnboarding() {
    }
}