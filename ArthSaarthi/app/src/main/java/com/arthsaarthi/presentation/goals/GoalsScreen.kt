package com.arthsaarthi.presentation.goals

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.data.db.Goal
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.toRupees

@Composable
fun GoalsScreen(viewModel: GoalsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }

    if (showAddDialog) {
        AddGoalDialog(
            onDismiss = { showAddDialog = false },
            onSave = { name, type, target, years ->
                viewModel.addGoal(name, type, target, years)
                showAddDialog = false
            }
        )
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddDialog = true }, containerColor = Navy) {
                Icon(Icons.Filled.Add, contentDescription = "Add Goal", tint = Color.White)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).background(Color(0xFFF0F4F8))
        ) {
            Box(modifier = Modifier.fillMaxWidth().background(Navy).padding(16.dp)) {
                Column {
                    Text("Financial Goals", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("Jeevan ke sapne, systematic planning ke saath", color = Color.White.copy(0.7f), fontSize = 12.sp)
                }
            }

            if (uiState.goals.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("🎯", fontSize = 56.sp)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("No goals set yet", color = Color.Gray, fontWeight = FontWeight.Medium)
                        Text("Add goals like Ghar, Shaadi, Education", color = Color.Gray, fontSize = 12.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Tap + to add your first goal", color = Teal, fontSize = 12.sp)
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(top = 12.dp, bottom = 80.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.goals) { goal ->
                        GoalCard(goal = goal, onDelete = { viewModel.delete(goal) })
                    }
                }
            }
        }
    }
}

fun goalEmoji(type: String) = when (type) {
    "MARRIAGE" -> "💍"
    "HOME" -> "🏠"
    "EDUCATION" -> "🎓"
    "EMERGENCY" -> "🆘"
    "VEHICLE" -> "🚗"
    "RETIREMENT" -> "👴"
    "PILGRIMAGE" -> "🛕"
    else -> "🎯"
}

@Composable
fun GoalCard(goal: Goal, onDelete: () -> Unit) {
    val progress = if (goal.targetAmountPaise > 0)
        (goal.savedAmountPaise.toFloat() / goal.targetAmountPaise).coerceIn(0f, 1f)
    else 0f

    // Monthly SIP needed
    val remaining = goal.targetAmountPaise - goal.savedAmountPaise
    val monthsLeft = maxOf(1L, (goal.deadlineMillis - System.currentTimeMillis()) / (30L * 24 * 60 * 60 * 1000))
    val monthlySip = if (monthsLeft > 0) remaining / monthsLeft else remaining

    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(goalEmoji(goal.goalType), fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(goal.name, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Navy)
                    Text(goal.goalType, color = Color.Gray, fontSize = 12.sp)
                }
                IconButton(onClick = onDelete, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = ErrorRed.copy(0.5f), modifier = Modifier.size(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("Target", color = Color.Gray, fontSize = 10.sp)
                    Text(goal.targetAmountPaise.toRupees(), fontWeight = FontWeight.Bold, color = Navy)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text("Saved", color = Color.Gray, fontSize = 10.sp)
                    Text(goal.savedAmountPaise.toRupees(), fontWeight = FontWeight.Bold, color = SuccessGreen)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
                color = when {
                    progress >= 1f -> SuccessGreen
                    progress >= 0.5f -> WarningOrange
                    else -> Teal
                },
                trackColor = Color(0xFFE0E0E0)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("${(progress * 100).toInt()}% achieved", color = Color.Gray, fontSize = 11.sp)

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Navy.copy(0.07f))
                    .padding(10.dp)
            ) {
                Text(
                    "💡 Start SIP of ${monthlySip.toRupees()}/month to reach this goal in $monthsLeft months",
                    fontSize = 12.sp, color = Navy
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalDialog(
    onDismiss: () -> Unit,
    onSave: (name: String, type: String, target: Long, years: Int) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("HOME") }
    var target by remember { mutableStateOf("") }
    var years by remember { mutableStateOf("5") }

    val goalTypes = listOf(
        "HOME" to "🏠 Ghar",
        "MARRIAGE" to "💍 Shaadi",
        "EDUCATION" to "🎓 Padhai",
        "EMERGENCY" to "🆘 Emergency",
        "VEHICLE" to "🚗 Gaadi",
        "RETIREMENT" to "👴 Retirement",
        "PILGRIMAGE" to "🛕 Pilgrimage"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Financial Goal", fontWeight = FontWeight.Bold, color = Navy) },
        text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text("Goal Type", fontWeight = FontWeight.Medium, fontSize = 13.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    goalTypes.forEach { (code, label) ->
                        FilterChip(
                            selected = type == code,
                            onClick = { type = code; name = label.drop(3) },
                            label = { Text(label, fontSize = 11.sp) },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = Navy, selectedLabelColor = Color.White)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Goal Name") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = target, onValueChange = { target = it }, label = { Text("Target Amount (₹)") }, modifier = Modifier.fillMaxWidth(), singleLine = true, keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Number))
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = years, onValueChange = { years = it }, label = { Text("Years to achieve") }, modifier = Modifier.fillMaxWidth(), singleLine = true, keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Number))
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val targetPaise = (target.toLongOrNull() ?: 0L) * 100
                    val yearsInt = years.toIntOrNull() ?: 5
                    if (name.isNotBlank() && targetPaise > 0) onSave(name, type, targetPaise, yearsInt)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Navy)
            ) { Text("Save Goal") }
        },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Cancel") } }
    )
}
