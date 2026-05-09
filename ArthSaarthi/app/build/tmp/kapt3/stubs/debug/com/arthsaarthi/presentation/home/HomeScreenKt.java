package com.arthsaarthi.presentation.home;

import androidx.compose.foundation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import com.arthsaarthi.data.db.Transaction;
import com.arthsaarthi.ui.theme.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a.\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0012"}, d2 = {"HeaderCard", "", "uiState", "Lcom/arthsaarthi/presentation/home/HomeUiState;", "onSettings", "Lkotlin/Function0;", "HomeScreen", "onAddTransaction", "viewModel", "Lcom/arthsaarthi/presentation/home/HomeViewModel;", "MonthSummaryCard", "TopCategoriesCard", "TransactionItem", "transaction", "Lcom/arthsaarthi/data/db/Transaction;", "getCategoryEmoji", "", "category", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddTransaction, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettings, @org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.home.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HeaderCard(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.home.HomeUiState uiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettings) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MonthSummaryCard(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.home.HomeUiState uiState) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TopCategoriesCard(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.presentation.home.HomeUiState uiState) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TransactionItem(@org.jetbrains.annotations.NotNull
    com.arthsaarthi.data.db.Transaction transaction) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getCategoryEmoji(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
        return null;
    }
}