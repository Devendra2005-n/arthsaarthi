package com.arthsaarthi.presentation.settings

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBack: () -> Unit, viewModel: SettingsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", color = Color.White) },
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
            Spacer(modifier = Modifier.height(16.dp))

            // Profile card
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Navy)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(28.dp))
                            .background(Gold),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            uiState.name.firstOrNull()?.uppercaseChar()?.toString() ?: "A",
                            fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Navy
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(uiState.name.ifEmpty { "ArthSaarthi User" }, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(uiState.incomeType.replace("_", " "), color = Color.White.copy(0.7f), fontSize = 13.sp)
                        Text(uiState.state, color = Color.White.copy(0.7f), fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Language section
            SettingsSection("Language / भाषा") {
                val languages = listOf("en" to "English", "hi" to "हिंदी", "mr" to "मराठी", "ta" to "தமிழ்", "te" to "తెలుగు", "kn" to "ಕನ್ನಡ")
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()).padding(horizontal = 16.dp, vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    languages.forEach { (code, label) ->
                        FilterChip(
                            selected = uiState.language == code,
                            onClick = { viewModel.setLanguage(code) },
                            label = { Text(label) },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = Navy, selectedLabelColor = Color.White)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // App info section
            SettingsSection("About ArthSaarthi") {
                SettingsRow(Icons.Filled.Info, "Version", "1.0.0")
                SettingsRow(Icons.Filled.Security, "Data Privacy", "All data stored on your device only")
                SettingsRow(Icons.Filled.PhoneAndroid, "Platform", "Android (Offline First)")
                SettingsRow(Icons.Filled.Code, "Source Code", "github.com/arthsaarthi")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Features section
            SettingsSection("Features Available") {
                listOf(
                    "✅ Expense tracking with SMS auto-detection",
                    "✅ SIP, FD, PPF, Gold, EPF investment tracker",
                    "✅ Tax optimizer (Old vs New regime)",
                    "✅ Financial goals with SIP suggestions",
                    "✅ Government scheme eligibility checker",
                    "✅ 12 Indian languages support",
                    "✅ Works fully offline",
                    "✅ No data sold to third parties — ever"
                ).forEach { feature ->
                    Text(
                        feature,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 3.dp),
                        fontSize = 13.sp,
                        color = Color(0xFF333333)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Privacy notice
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = SuccessGreen.copy(0.1f))
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.Top) {
                    Text("🔒", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Privacy Guaranteed", fontWeight = FontWeight.Bold, color = SuccessGreen, fontSize = 14.sp)
                        Text(
                            "Your financial data is stored only on your phone. ArthSaarthi does not send your personal data to any server. No ads. No data selling. Ever.",
                            fontSize = 12.sp, color = Color(0xFF333333)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SettingsSection(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column {
            Text(
                title,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                fontWeight = FontWeight.Bold,
                color = Navy,
                fontSize = 14.sp
            )
            Divider(color = Color(0xFFEEEEEE))
            content()
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SettingsRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Navy, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(label, fontSize = 14.sp, color = Color(0xFF333333), modifier = Modifier.weight(1f))
        Text(value, fontSize = 13.sp, color = Color.Gray)
    }
}
