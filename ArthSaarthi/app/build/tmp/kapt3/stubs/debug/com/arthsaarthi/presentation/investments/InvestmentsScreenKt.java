package com.arthsaarthi.presentation.investments;

import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.arthsaarthi.data.db.Investment;
import com.arthsaarthi.ui.theme.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032u\u0010\u0004\u001aq\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a9\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u0012\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"H\u0007\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"AddInvestmentDialog", "", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "type", "", "invested", "", "rate", "bank", "InvMetric", "label", "value", "modifier", "Landroidx/compose/ui/Modifier;", "valueColor", "Landroidx/compose/ui/graphics/Color;", "InvMetric-g2O1Hgs", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;J)V", "InvSummaryChip", "color", "InvSummaryChip-9LQNqLg", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;)V", "InvestmentCard", "investment", "Lcom/arthsaarthi/data/db/Investment;", "onDelete", "InvestmentsScreen", "viewModel", "Lcom/arthsaarthi/presentation/investments/InvestmentsViewModel;", "app_debug"})
public final class InvestmentsScreenKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void InvestmentsScreen(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.investments.InvestmentsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void InvestmentCard(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Investment investment, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void AddInvestmentDialog(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function5<? super java.lang.String, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Double, ? super java.lang.String, kotlin.Unit> onSave) {
    }
}