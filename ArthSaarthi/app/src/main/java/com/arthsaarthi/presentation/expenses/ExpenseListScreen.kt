@file:OptIn(ExperimentalMaterial3Api::class)
package com.arthsaarthi.presentation.expenses

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.data.db.Transaction
import com.arthsaarthi.presentation.home.getCategoryEmoji
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.toReadableDate
import com.arthsaarthi.utils.toRupees

@Composable
fun ExpenseListScreen(viewModel: ExpenseListViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var filterType by remember { mutableStateOf("ALL") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(16.dp)
        ) {
            Column {
                Text(
                    "All Transactions",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    SummaryPill(
                        "Income",
                        uiState.totalIncome.toRupees(),
                        SuccessGreen,
                        Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    SummaryPill(
                        "Spent",
                        uiState.totalSpend.toRupees(),
                        ErrorRed,
                        Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    val balance = uiState.totalIncome - uiState.totalSpend
                    SummaryPill(
                        "Balance",
                        balance.toRupees(),
                        if (balance >= 0) Gold else ErrorRed,
                        Modifier.weight(1f)
                    )
                }
            }
        }

        // Filter tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("ALL", "EXPENSE", "INCOME").forEach { type ->
                FilterChip(
                    selected = filterType == type,
                    onClick = { filterType = type },
                    label = {
                        Text(
                            when (type) {
                                "ALL" -> "All"
                                "EXPENSE" -> "Expenses"
                                else -> "Income"
                            },
                            fontSize = 12.sp
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Navy,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        // Transaction list
        val filtered = if (filterType == "ALL") uiState.transactions
        else uiState.transactions.filter { it.type == filterType }

        if (filtered.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("📋", fontSize = 48.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("No transactions found", color = Color.Gray)
                    Text(
                        "Tap + to add your first transaction",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 8.dp,
                    bottom = 80.dp
                ),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(filtered, key = { it.id }) { transaction ->
                    ExpenseListItem(
                        transaction = transaction,
                        onDelete = { viewModel.delete(transaction.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun ExpenseListItem(transaction: Transaction, onDelete: () -> Unit) {
    var showDeleteConfirm by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Category icon
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(
                        if (transaction.type == "INCOME")
                            SuccessGreen.copy(alpha = 0.12f)
                        else
                            ErrorRed.copy(alpha = 0.12f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(getCategoryEmoji(transaction.category), fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Details
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    transaction.merchantName.ifEmpty { transaction.category },
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    "${transaction.category} · ${transaction.paymentMode} · ${transaction.dateMillis.toReadableDate()}",
                    color = Color.Gray,
                    fontSize = 11.sp
                )
                if (transaction.note.isNotEmpty()) {
                    Text(
                        transaction.note,
                        color = Color(0xFF888888),
                        fontSize = 11.sp,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Amount
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "${if (transaction.type == "INCOME") "+" else "-"}${transaction.amountPaise.toRupees()}",
                    color = if (transaction.type == "INCOME") SuccessGreen else ErrorRed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Delete button
                if (showDeleteConfirm) {
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        TextButton(
                            onClick = { showDeleteConfirm = false },
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
                        ) {
                            Text("No", fontSize = 11.sp, color = Color.Gray)
                        }
                        TextButton(
                            onClick = {
                                showDeleteConfirm = false
                                onDelete()
                            },
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 0.dp)
                        ) {
                            Text("Yes", fontSize = 11.sp, color = ErrorRed)
                        }
                    }
                } else {
                    IconButton(
                        onClick = { showDeleteConfirm = true },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Delete",
                            tint = Color.LightGray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SummaryPill(
    label: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.15f))
            .padding(8.dp)
    ) {
        Text(label, color = Color.White.copy(0.7f), fontSize = 10.sp)
        Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 13.sp)
    }
}