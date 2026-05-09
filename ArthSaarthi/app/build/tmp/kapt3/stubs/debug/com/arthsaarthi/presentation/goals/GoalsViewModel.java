package com.arthsaarthi.presentation.goals;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import com.arthsaarthi.data.db.Goal;
import com.arthsaarthi.data.db.GoalDao;
import kotlinx.coroutines.flow.*;
import java.util.Calendar;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/arthsaarthi/presentation/goals/GoalsViewModel;", "Landroidx/lifecycle/ViewModel;", "goalDao", "Lcom/arthsaarthi/data/db/GoalDao;", "(Lcom/arthsaarthi/data/db/GoalDao;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/arthsaarthi/presentation/goals/GoalsUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addGoal", "", "name", "", "type", "targetPaise", "", "years", "", "delete", "goal", "Lcom/arthsaarthi/data/db/Goal;", "app_debug"})
public final class GoalsViewModel extends androidx.lifecycle.ViewModel {
    private final com.arthsaarthi.data.db.GoalDao goalDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.goals.GoalsUiState> uiState = null;
    
    @javax.inject.Inject
    public GoalsViewModel(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.GoalDao goalDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.arthsaarthi.presentation.goals.GoalsUiState> getUiState() {
        return null;
    }
    
    public final void addGoal(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String type, long targetPaise, int years) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Goal goal) {
    }
}