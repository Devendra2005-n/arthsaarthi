package com.arthsaarthi.presentation.investments

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.arthsaarthi.data.db.Investment
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.toReadableDate
import com.arthsaarthi.utils.toRupees

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestmentsScreen(viewModel: InvestmentsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf("All", "SIP/MF", "FD/RD", "PPF/EPF", "Gold")

    if (showAddDialog) {
        AddInvestmentDialog(
            onDismiss = { showAddDialog = false },
            onSave = { type, name, invested, rate, bankName ->
                viewModel.addInvestment(type, name, invested, rate, bankName)
                showAddDialog = false
            }
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = Navy
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
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
                    Text("Investments", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        InvSummaryChip("Invested", uiState.totalInvested.toRupees(), Gold, Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(8.dp))
                        InvSummaryChip("Current Value", uiState.totalCurrentValue.toRupees(), SuccessGreen, Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    val gain = uiState.totalCurrentValue - uiState.totalInvested
                    val gainPct = if (uiState.totalInvested > 0) (gain.toFloat() / uiState.totalInvested * 100) else 0f
                    Text(
                        "Total Gain: ${gain.toRupees()} (${String.format("%.1f", gainPct)}%)",
                        color = if (gain >= 0) SuccessGreen else ErrorRed,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }

            // Tab row
            ScrollableTabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                contentColor = Navy,
                edgePadding = 0.dp
            ) {
                tabs.forEachIndexed { i, tab ->
                    Tab(
                        selected = selectedTab == i,
                        onClick = { selectedTab = i },
                        text = { Text(tab) }
                    )
                }
            }

            // Filter investments
            val filtered = when (selectedTab) {
                1 -> uiState.investments.filter { it.type in listOf("SIP", "MF") }
                2 -> uiState.investments.filter { it.type in listOf("FD", "RD") }
                3 -> uiState.investments.filter { it.type in listOf("PPF", "EPF", "NPS") }
                4 -> uiState.investments.filter { it.type == "GOLD" }
                else -> uiState.investments
            }

            if (filtered.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("📈", fontSize = 48.sp)
                        Text("No investments added yet", color = Color.Gray)
                        Text("Tap + to add SIP, FD, Gold etc.", color = Color.Gray, fontSize = 12.sp)
                    }
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(bottom = 80.dp, top = 8.dp)) {
                    items(filtered) { investment ->
                        InvestmentCard(investment = investment, onDelete = { viewModel.delete(investment) })
                    }
                }
            }
        }
    }
}

@Composable
fun InvSummaryChip(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.15f))
            .padding(10.dp)
    ) {
        Text(label, color = Color.White.copy(0.7f), fontSize = 10.sp)
        Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}

@Composable
fun InvestmentCard(investment: Investment, onDelete: () -> Unit) {
    val emoji = when (investment.type) {
        "SIP", "MF" -> "📊"
        "FD" -> "🏦"
        "RD" -> "📅"
        "PPF" -> "📮"
        "EPF" -> "🏢"
        "NPS" -> "👴"
        "GOLD" -> "🥇"
        "STOCKS" -> "📈"
        else -> "💰"
    }
    val gain = investment.currentValuePaise - investment.investedAmountPaise

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(emoji, fontSize = 28.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(investment.name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Navy)
                    Text(
                        "${investment.type}${if (investment.bankName.isNotEmpty()) " · ${investment.bankName}" else ""}",
                        color = Color.Gray, fontSize = 11.sp
                    )
                }
                IconButton(onClick = onDelete, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = ErrorRed.copy(0.6f), modifier = Modifier.size(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                InvMetric("Invested", investment.investedAmountPaise.toRupees(), Modifier.weight(1f))
                InvMetric("Current", investment.currentValuePaise.toRupees(), Modifier.weight(1f))
                InvMetric(
                    "Gain/Loss",
                    "${if (gain >= 0) "+" else ""}${gain.toRupees()}",
                    Modifier.weight(1f),
                    if (gain >= 0) SuccessGreen else ErrorRed
                )
            }
            if (investment.interestRate > 0) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Rate: ${investment.interestRate}% p.a.${if (investment.maturityDateMillis > 0) " · Matures: ${investment.maturityDateMillis.toReadableDate()}" else ""}",
                    color = Color.Gray, fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun InvMetric(label: String, value: String, modifier: Modifier = Modifier, valueColor: Color = Navy) {
    Column(modifier = modifier) {
        Text(label, color = Color.Gray, fontSize = 10.sp)
        Text(value, color = valueColor, fontWeight = FontWeight.Bold, fontSize = 13.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddInvestmentDialog(
    onDismiss: () -> Unit,
    onSave: (type: String, name: String, invested: Long, rate: Double, bank: String) -> Unit
) {
    var type by remember { mutableStateOf("SIP") }
    var name by remember { mutableStateOf("") }
    var invested by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    var bank by remember { mutableStateOf("") }

    val types = listOf("SIP", "MF", "FD", "RD", "PPF", "EPF", "NPS", "GOLD", "STOCKS")

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Investment", fontWeight = FontWeight.Bold, color = Navy) },
        text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                // Type selector
                Text("Type", fontWeight = FontWeight.Medium, fontSize = 13.sp, color = Color.Gray)
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    types.forEach { t ->
                        FilterChip(
                            selected = type == t,
                            onClick = { type = t },
                            label = { Text(t, fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Navy,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name (e.g. HDFC Mid Cap SIP)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = invested, onValueChange = { invested = it }, label = { Text("Amount Invested (₹)") }, modifier = Modifier.fillMaxWidth(), singleLine = true, keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number))
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = rate, onValueChange = { rate = it }, label = { Text("Interest/Return Rate % (optional)") }, modifier = Modifier.fillMaxWidth(), singleLine = true, keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number))
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = bank, onValueChange = { bank = it }, label = { Text("Bank/Fund House (optional)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val investedPaise = (invested.toDoubleOrNull() ?: 0.0).times(100).toLong()
                    if (name.isNotBlank() && investedPaise > 0) {
                        onSave(type, name, investedPaise, rate.toDoubleOrNull() ?: 0.0, bank)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Navy)
            ) { Text("Save") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    )
}
