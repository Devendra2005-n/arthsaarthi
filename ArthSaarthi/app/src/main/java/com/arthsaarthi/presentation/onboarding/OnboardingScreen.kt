package com.arthsaarthi.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arthsaarthi.ui.theme.Gold
import com.arthsaarthi.ui.theme.Navy
import com.arthsaarthi.ui.theme.Teal

@Composable
fun OnboardingScreen(
    onOnboardingComplete: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isComplete) {
        LaunchedEffect(Unit) { onOnboardingComplete() }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A2342))
    ) {
        // Progress indicator
        LinearProgressIndicator(
            progress = (uiState.currentStep + 1) / 5f,
            modifier = Modifier.fillMaxWidth().height(4.dp),
            color = Gold,
            trackColor = Color.White.copy(alpha = 0.3f)
        )

        when (uiState.currentStep) {
            0 -> WelcomeStep(onNext = { viewModel.nextStep() })
            1 -> LanguageStep(selected = uiState.language, onSelect = { viewModel.setLanguage(it) }, onNext = { viewModel.nextStep() })
            2 -> IncomeTypeStep(selected = uiState.incomeType, onSelect = { viewModel.setIncomeType(it) }, onNext = { viewModel.nextStep() })
            3 -> CityStep(selected = uiState.cityTier, onSelect = { viewModel.setCityTier(it) }, onNext = { viewModel.nextStep() })
            4 -> NameStep(name = uiState.name, onNameChange = { viewModel.setName(it) }, onComplete = { viewModel.completeOnboarding() })
        }
    }
}

@Composable
fun WelcomeStep(onNext: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🇮🇳", fontSize = 64.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            "ArthSaarthi",
            color = Gold,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "अर्थसारथी",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "India's Personal Finance Advisor\nWorks Offline · 12 Languages · Free Forever",
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))

        // Feature highlights
        listOf(
            "📊 Track all expenses automatically",
            "💰 SIP, FD, Gold, EPF tracker",
            "🧾 Tax optimizer (Old vs New regime)",
            "🌾 Agricultural income support",
            "🏛️ Govt scheme eligibility checker"
        ).forEach { feature ->
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Text(feature, color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Gold)
        ) {
            Text("Get Started →", color = Navy, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun LanguageStep(selected: String, onSelect: (String) -> Unit, onNext: () -> Unit) {
    val languages = listOf(
        "en" to "English", "hi" to "हिंदी", "mr" to "मराठी",
        "ta" to "தமிழ்", "te" to "తెలుగు", "kn" to "ಕನ್ನಡ",
        "bn" to "বাংলা", "gu" to "ગુજરાતી", "pa" to "ਪੰਜਾਬੀ",
        "ml" to "മലയാളം", "or" to "ଓଡ଼ିଆ", "as" to "অসমীয়া"
    )

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Choose Language", color = Gold, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("अपनी भाषा चुनें", color = Color.White.copy(alpha = 0.6f), fontSize = 14.sp)
        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(languages) { (code, name) ->
                val isSelected = selected == code
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) Gold else Color.White.copy(alpha = 0.1f))
                        .clickable { onSelect(code) }
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        name,
                        color = if (isSelected) Navy else Color.White,
                        fontSize = 14.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            enabled = selected.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(containerColor = Gold)
        ) {
            Text("Next →", color = Navy, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun IncomeTypeStep(selected: String, onSelect: (String) -> Unit, onNext: () -> Unit) {
    val types = listOf(
        Triple("SALARIED", "💼", "Salaried"),
        Triple("SELF_EMPLOYED", "🏪", "Self-Employed"),
        Triple("FARMER", "🌾", "Farmer"),
        Triple("GIG", "🛵", "Gig Worker"),
        Triple("PENSIONER", "👴", "Pensioner"),
        Triple("HOMEMAKER", "🏠", "Homemaker")
    )

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("What's your income type?", color = Gold, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("आप क्या करते हैं?", color = Color.White.copy(alpha = 0.6f), fontSize = 14.sp)
        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(types) { (code, emoji, label) ->
                val isSelected = selected == code
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (isSelected) Gold else Color.White.copy(alpha = 0.1f))
                        .clickable { onSelect(code) }
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(emoji, fontSize = 32.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        label,
                        color = if (isSelected) Navy else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            enabled = selected.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(containerColor = Gold)
        ) {
            Text("Next →", color = Navy, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun CityStep(selected: String, onSelect: (String) -> Unit, onNext: () -> Unit) {
    val tiers = listOf(
        Triple("METRO", "🏙️", "Metro City\nMumbai, Delhi, Bengaluru,\nChennai, Hyderabad, Kolkata"),
        Triple("TIER1", "🌆", "Tier 1 City\nPune, Ahmedabad, Jaipur,\nLucknow, Chandigarh"),
        Triple("TIER2", "🌇", "Tier 2 City\nNagpur, Surat, Indore,\nBhopal, Coimbatore"),
        Triple("TIER3", "🏘️", "Tier 3 City\nSmaller cities and\nDistrict headquarters"),
        Triple("RURAL", "🌾", "Village / Rural\nGram Panchayat area")
    )

    Column(modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Where do you live?", color = Gold, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("आप कहाँ रहते हैं?", color = Color.White.copy(alpha = 0.6f), fontSize = 14.sp)
        Spacer(modifier = Modifier.height(24.dp))

        tiers.forEach { (code, emoji, label) ->
            val isSelected = selected == code
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) Gold else Color.White.copy(alpha = 0.1f))
                    .clickable { onSelect(code) }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(emoji, fontSize = 28.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    label,
                    color = if (isSelected) Navy else Color.White,
                    fontSize = 13.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
                Spacer(modifier = Modifier.weight(1f))
                if (isSelected) Icon(Icons.Filled.Check, contentDescription = null, tint = Navy)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            enabled = selected.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(containerColor = Gold)
        ) {
            Text("Next →", color = Navy, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun NameStep(name: String, onNameChange: (String) -> Unit, onComplete: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🙏", fontSize = 48.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text("What's your name?", color = Gold, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("आपका नाम क्या है?", color = Color.White.copy(alpha = 0.6f), fontSize = 14.sp)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Your Name", color = Color.White.copy(alpha = 0.7f)) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Gold,
                unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                cursorColor = Gold
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onComplete,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            enabled = name.isNotBlank(),
            colors = ButtonDefaults.buttonColors(containerColor = Gold)
        ) {
            Text("Start Using ArthSaarthi ✓", color = Navy, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}
