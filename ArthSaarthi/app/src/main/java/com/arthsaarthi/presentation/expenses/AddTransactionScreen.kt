package com.arthsaarthi.presentation.expenses

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.ml.VoiceCommandParser
import com.arthsaarthi.ml.VoiceInputManager
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.EXPENSE_CATEGORIES
import com.arthsaarthi.utils.INCOME_CATEGORIES
import com.arthsaarthi.utils.PAYMENT_MODES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionScreen(
    onBack: () -> Unit,
    viewModel: AddTransactionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    var voiceManager by remember { mutableStateOf<VoiceInputManager?>(null) }
    var isListening by remember { mutableStateOf(false) }
    var voiceStatusText by remember { mutableStateOf("") }

    DisposableEffect(Unit) {
        voiceManager = VoiceInputManager(context)
        onDispose { voiceManager?.destroy() }
    }

    if (uiState.isSaved) {
        LaunchedEffect(Unit) { onBack() }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Transaction", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Navy)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF0F4F8))
                .verticalScroll(rememberScrollState())
        ) {
            // Type Toggle
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
            ) {
                listOf("EXPENSE", "INCOME").forEach { type ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (uiState.type == type)
                                    (if (type == "EXPENSE") ErrorRed else SuccessGreen)
                                else Color.White
                            )
                            .clickable { viewModel.setType(type) }
                            .padding(vertical = 14.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (type == "EXPENSE") "💸 Expense" else "💰 Income",
                            color = if (uiState.type == type) Color.White else Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
            }

            // Amount display
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Navy)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Amount", color = Color.White.copy(0.7f), fontSize = 13.sp)
                    Text(
                        text = if (uiState.amountDisplay.isEmpty()) "₹0" else "₹${uiState.amountDisplay}",
                        color = Gold,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (voiceStatusText.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(voiceStatusText, color = Color.White.copy(0.7f), fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Numpad
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                val buttons = listOf("1","2","3","4","5","6","7","8","9",".","0","⌫")
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.height(220.dp).padding(8.dp),
                    userScrollEnabled = false
                ) {
                    items(buttons) { btn ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (btn == "⌫") ErrorRed.copy(0.1f) else Color(0xFFF5F5F5))
                                .clickable {
                                    if (btn == "⌫") viewModel.backspace()
                                    else viewModel.appendDigit(btn)
                                }
                                .padding(vertical = 14.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = btn,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (btn == "⌫") ErrorRed else Navy
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Voice Button
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        if (isListening) {
                            voiceManager?.stop()
                            isListening = false
                            voiceStatusText = ""
                        } else {
                            isListening = true
                            voiceStatusText = "🎤 Listening... बोलिए"
                            voiceManager?.startListening(
                                languageCode = "hi-IN",
                                onResult = { text ->
                                    isListening = false
                                    val parsed = VoiceCommandParser.parse(text)
                                    parsed.amountPaise?.let { viewModel.setAmountFromPaise(it) }
                                    parsed.category?.let { viewModel.setCategory(it) }
                                    parsed.paymentMode?.let { viewModel.setPaymentMode(it) }
                                    if (parsed.isIncome) viewModel.setType("INCOME")
                                    voiceStatusText = "\"$text\""
                                },
                                onError = {
                                    isListening = false
                                    voiceStatusText = "Voice not recognized. Try again."
                                }
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isListening) ErrorRed else Teal
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        if (isListening) Icons.Filled.MicOff else Icons.Filled.Mic,
                        contentDescription = "Voice",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        if (isListening) "Stop" else "🎤 Voice (Hindi)",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Category Picker
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Category", fontWeight = FontWeight.Bold, color = Navy, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    val categories = if (uiState.type == "INCOME") INCOME_CATEGORIES else EXPENSE_CATEGORIES
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                        modifier = Modifier.height(210.dp),
                        userScrollEnabled = false,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(categories) { cat ->
                            val isSelected = uiState.category == cat.name
                            Column(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isSelected) Navy else Color(0xFFF5F5F5))
                                    .clickable { viewModel.setCategory(cat.name) }
                                    .padding(6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(cat.emoji, fontSize = 20.sp)
                                Text(
                                    cat.name,
                                    fontSize = 9.sp,
                                    color = if (isSelected) Color.White else Color.Gray,
                                    textAlign = TextAlign.Center,
                                    maxLines = 2
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Payment Mode
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Payment Mode", fontWeight = FontWeight.Bold, color = Navy, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PAYMENT_MODES.forEach { mode ->
                            FilterChip(
                                selected = uiState.paymentMode == mode,
                                onClick = { viewModel.setPaymentMode(mode) },
                                label = { Text(mode, fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = Navy,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Merchant and Note
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    OutlinedTextField(
                        value = uiState.merchantName,
                        onValueChange = viewModel::setMerchant,
                        label = { Text("Merchant / Shop name (optional)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Filled.Store, null, tint = Navy) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = uiState.note,
                        onValueChange = viewModel::setNote,
                        label = { Text("Note (optional)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Filled.Edit, null, tint = Navy) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Save Button
            Button(
                onClick = viewModel::save,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(54.dp),
                enabled = uiState.amountDisplay.isNotEmpty() && uiState.category.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(containerColor = Navy),
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(Icons.Filled.Check, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Save Transaction", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
