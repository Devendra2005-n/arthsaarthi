package com.arthsaarthi.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.data.db.Transaction
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.toReadableDate
import com.arthsaarthi.utils.toRupees

@Composable
fun HomeScreen(
    onAddTransaction: () -> Unit,
    onSettings: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF0F4F8)),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        // Header card
        item { HeaderCard(uiState, onSettings) }

        // Month summary
        item { MonthSummaryCard(uiState) }

        // Top spending categories
        if (uiState.topCategories.isNotEmpty()) {
            item { TopCategoriesCard(uiState) }
        }

        // Recent transactions
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Recent Transactions", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Navy)
            }
        }

        if (uiState.recentTransactions.isEmpty()) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("💸", fontSize = 48.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("No transactions yet", color = Color.Gray)
                        Text("Tap + to add your first expense", color = Color.Gray, fontSize = 12.sp)
                    }
                }
            }
        } else {
            items(uiState.recentTransactions) { transaction ->
                TransactionItem(transaction = transaction)
            }
        }
    }
}

@Composable
fun HeaderCard(uiState: HomeUiState, onSettings: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(Navy, Color(0xFF1565C0))))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "नमस्ते 🙏 ${uiState.userName}",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text("Your Financial Dashboard", color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
                }
                IconButton(onClick = onSettings) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Net Worth", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
            Text(
                uiState.netWorth.toRupees(),
                color = Gold,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White.copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text("Total Assets: ${uiState.totalAssets.toRupees()}", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Text("Loans: ${uiState.totalLoans.toRupees()}", color = ErrorRed.copy(alpha = 0.9f), fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun MonthSummaryCard(uiState: HomeUiState) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("This Month", fontWeight = FontWeight.Bold, color = Navy, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Income", color = Color.Gray, fontSize = 12.sp)
                    Text(
                        uiState.thisMonthIncome.toRupees(),
                        color = SuccessGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Spent", color = Color.Gray, fontSize = 12.sp)
                    Text(
                        uiState.thisMonthSpend.toRupees(),
                        color = ErrorRed,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Saved", color = Color.Gray, fontSize = 12.sp)
                    val saved = uiState.thisMonthIncome - uiState.thisMonthSpend
                    Text(
                        saved.toRupees(),
                        color = if (saved >= 0) SuccessGreen else ErrorRed,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            if (uiState.thisMonthIncome > 0) {
                Spacer(modifier = Modifier.height(12.dp))
                val spendRatio = (uiState.thisMonthSpend.toFloat() / uiState.thisMonthIncome.toFloat()).coerceIn(0f, 1f)
                LinearProgressIndicator(
                    progress = spendRatio,
                    modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
                    color = when {
                        spendRatio < 0.6f -> SuccessGreen
                        spendRatio < 0.8f -> WarningOrange
                        else -> ErrorRed
                    },
                    trackColor = Color(0xFFE0E0E0)
                )
                Text(
                    "${(spendRatio * 100).toInt()}% of income spent",
                    color = Color.Gray,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun TopCategoriesCard(uiState: HomeUiState) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Top Spending Categories", fontWeight = FontWeight.Bold, color = Navy, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(12.dp))
            uiState.topCategories.take(3).forEach { (category, amount) ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(category, fontSize = 14.sp, color = Color(0xFF333333))
                    Text(amount.toRupees(), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = ErrorRed)
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Category icon circle
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(if (transaction.type == "INCOME") SuccessGreen.copy(alpha = 0.1f) else ErrorRed.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text(getCategoryEmoji(transaction.category), fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    transaction.merchantName.ifEmpty { transaction.category },
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    "${transaction.category} · ${transaction.dateMillis.toReadableDate()}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "${if (transaction.type == "INCOME") "+" else "-"}${transaction.amountPaise.toRupees()}",
                    color = if (transaction.type == "INCOME") SuccessGreen else ErrorRed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    transaction.paymentMode,
                    color = Color.Gray,
                    fontSize = 11.sp
                )
            }
        }
    }
}

fun getCategoryEmoji(category: String): String {
    return when (category) {
        "Groceries" -> "🛒"
        "Petrol/Diesel" -> "⛽"
        "Restaurant" -> "🍽️"
        "Vegetables" -> "🥦"
        "Electricity" -> "💡"
        "Mobile Recharge" -> "📱"
        "EMI" -> "🏦"
        "Rent" -> "🏠"
        "School Fees" -> "📚"
        "Doctor" -> "🏥"
        "Medicines" -> "💊"
        "Milk" -> "🥛"
        "LPG Cylinder" -> "🔵"
        "Auto/Cab" -> "🚗"
        "Train/Bus" -> "🚌"
        "Clothes" -> "👕"
        "Pooja/Religious" -> "🪔"
        "Salary" -> "💰"
        "Freelance" -> "💻"
        "Farm Income" -> "🌾"
        "SIP/Investment" -> "📈"
        else -> "📦"
    }
}
