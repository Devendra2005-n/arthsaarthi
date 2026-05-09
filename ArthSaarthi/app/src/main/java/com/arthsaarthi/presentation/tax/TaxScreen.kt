@file:OptIn(ExperimentalMaterial3Api::class)

package com.arthsaarthi.presentation.tax

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.arthsaarthi.ui.theme.*
import com.arthsaarthi.utils.GOVT_SCHEMES
import com.arthsaarthi.utils.toRupees

@Composable
fun TaxScreen(viewModel: TaxViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
            .verticalScroll(rememberScrollState())
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
                    "Tax Optimizer",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "FY 2025-26 · Old vs New Regime",
                    color = Color.White.copy(0.7f),
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Input Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Your Income Details",
                    fontWeight = FontWeight.Bold,
                    color = Navy,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                TaxInputField(
                    label = "Annual Gross Income (₹)",
                    value = uiState.grossIncome,
                    onValueChange = viewModel::setGrossIncome
                )
                TaxInputField(
                    label = "HRA Received per year (₹)",
                    value = uiState.hraReceived,
                    onValueChange = viewModel::setHraReceived
                )
                TaxInputField(
                    label = "Annual Rent Paid (₹)",
                    value = uiState.rentPaid,
                    onValueChange = viewModel::setRentPaid
                )
                TaxInputField(
                    label = "EPF Contribution per year (₹)",
                    value = uiState.epfContrib,
                    onValueChange = viewModel::setEpfContrib
                )
                TaxInputField(
                    label = "LIC + PPF + ELSS (80C) (₹)",
                    value = uiState.other80C,
                    onValueChange = viewModel::setOther80C
                )
                TaxInputField(
                    label = "Health Insurance Premium 80D (₹)",
                    value = uiState.healthInsurance,
                    onValueChange = viewModel::setHealthInsurance
                )
                TaxInputField(
                    label = "NPS Contribution 80CCD(1B) (₹)",
                    value = uiState.npsContrib,
                    onValueChange = viewModel::setNpsContrib
                )
                TaxInputField(
                    label = "Home Loan Interest 24(b) (₹)",
                    value = uiState.homeLoanInterest,
                    onValueChange = viewModel::setHomeLoanInterest
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Metro toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Metro City (Mumbai/Delhi/Bengaluru/Chennai)", fontSize = 13.sp, color = Color.Gray)
                    Switch(
                        checked = uiState.isMetro,
                        onCheckedChange = viewModel::setIsMetro,
                        colors = SwitchDefaults.colors(checkedThumbColor = Navy)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = viewModel::calculate,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Navy),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Filled.Calculate, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Calculate Tax",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Results
        if (uiState.showResults) {
            Spacer(modifier = Modifier.height(16.dp))

            // Regime comparison
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Navy)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Tax Comparison",
                        color = Gold,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        TaxRegimeBox(
                            label = "Old Regime",
                            amount = uiState.oldRegimeTax,
                            isRecommended = uiState.recommended == "Old Regime",
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        TaxRegimeBox(
                            label = "New Regime",
                            amount = uiState.newRegimeTax,
                            isRecommended = uiState.recommended == "New Regime",
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(SuccessGreen)
                            .padding(12.dp)
                    ) {
                        Text(
                            "✅ Recommended: ${uiState.recommended} — You save ${uiState.saving.toRupees()}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Deductions breakdown
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Deductions Breakdown",
                        fontWeight = FontWeight.Bold,
                        color = Navy,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    DeductionRow("Standard Deduction", uiState.standardDeduction.toRupees())
                    DeductionRow("HRA Exemption", uiState.hraExemption.toRupees())
                    DeductionRow("Section 80C", uiState.total80C.toRupees())
                    DeductionRow("Section 80D", uiState.health80D.toRupees())
                    DeductionRow("NPS 80CCD(1B)", uiState.nps80CCD.toRupees())
                    DeductionRow("Home Loan 24(b)", uiState.homeLoan24b.toRupees())
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Total Deductions",
                            fontWeight = FontWeight.Bold,
                            color = Navy
                        )
                        Text(
                            uiState.totalDeductions.toRupees(),
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 80C Status
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Section 80C Status",
                        fontWeight = FontWeight.Bold,
                        color = Navy,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    val used80C = uiState.total80C
                    val limit80C = 150000L
                    val progress = (used80C.toFloat() / limit80C.toFloat()).coerceIn(0f, 1f)
                    LinearProgressIndicator(
                        progress = progress,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        color = if (progress >= 1f) SuccessGreen else WarningOrange,
                        trackColor = Color(0xFFE0E0E0)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Used: ${used80C.toRupees()}",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Text(
                            "Limit: ₹1,50,000",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                    if (progress < 1f) {
                        Spacer(modifier = Modifier.height(8.dp))
                        val remaining = limit80C - used80C
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFFFF3E0))
                                .padding(10.dp)
                        ) {
                            Text(
                                "💡 Invest ${remaining.toRupees()} more in ELSS/PPF/NSC to save additional tax",
                                fontSize = 12.sp,
                                color = Color(0xFFE65100)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ITR Form
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📄", fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            "Recommended ITR Form",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                        Text(
                            uiState.itrForm,
                            fontWeight = FontWeight.Bold,
                            color = Navy,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }

        // Govt Schemes Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "🏛️ Government Schemes",
                    fontWeight = FontWeight.Bold,
                    color = Navy,
                    fontSize = 16.sp
                )
                Text(
                    "Schemes you may be eligible for",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(12.dp))

                GOVT_SCHEMES.take(5).forEach { scheme ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Navy.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🏛️", fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                scheme.name,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = Navy
                            )
                            Text(
                                scheme.benefit,
                                fontSize = 12.sp,
                                color = SuccessGreen
                            )
                            Text(
                                "Apply at: ${scheme.applyAt}",
                                fontSize = 11.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    if (scheme != GOVT_SCHEMES.take(5).last()) {
                        Divider(color = Color(0xFFEEEEEE))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun TaxInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontSize = 12.sp) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Navy,
            focusedLabelColor = Navy
        )
    )
}

@Composable
fun TaxRegimeBox(
    label: String,
    amount: Long,
    isRecommended: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isRecommended) Gold else Color.White.copy(alpha = 0.1f))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            label,
            color = if (isRecommended) Navy else Color.White.copy(0.7f),
            fontSize = 12.sp
        )
        Text(
            amount.toRupees(),
            color = if (isRecommended) Navy else Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        if (isRecommended) {
            Text("⭐ Best", color = Navy, fontSize = 11.sp)
        }
    }
}

@Composable
fun DeductionRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 13.sp, color = Color.Gray)
        Text(value, fontSize = 13.sp, color = Navy, fontWeight = FontWeight.Medium)
    }
}