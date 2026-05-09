package com.arthsaarthi.presentation.goals;

import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import com.arthsaarthi.data.db.Goal;
import com.arthsaarthi.ui.theme.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ax\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032`\u0010\u0004\u001a\\\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0012\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\u0016"}, d2 = {"AddGoalDialog", "", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "target", "", "years", "GoalCard", "goal", "Lcom/arthsaarthi/data/db/Goal;", "onDelete", "GoalsScreen", "viewModel", "Lcom/arthsaarthi/presentation/goals/GoalsViewModel;", "goalEmoji", "app_debug"})
public final class GoalsScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void GoalsScreen(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.goals.GoalsViewModel viewModel) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String goalEmoji(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    public static final void GoalCard(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Goal goal, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void AddGoalDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Integer, kotlin.Unit> onSave) {
    }
}