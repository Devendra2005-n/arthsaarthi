package com.arthsaarthi.presentation.tax

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class TaxUiState(
    val grossIncome: String = "",
    val hraReceived: String = "",
    val rentPaid: String = "",
    val epfContrib: String = "",
    val other80C: String = "",
    val healthInsurance: String = "",
    val npsContrib: String = "",
    val homeLoanInterest: String = "",
    val isMetro: Boolean = false,
    val showResults: Boolean = false,
    val oldRegimeTax: Long = 0L,
    val newRegimeTax: Long = 0L,
    val recommended: String = "",
    val saving: Long = 0L,
    val standardDeduction: Long = 0L,
    val hraExemption: Long = 0L,
    val total80C: Long = 0L,
    val health80D: Long = 0L,
    val nps80CCD: Long = 0L,
    val homeLoan24b: Long = 0L,
    val totalDeductions: Long = 0L,
    val itrForm: String = "ITR-1 (Sahaj)"
)

@HiltViewModel
class TaxViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(TaxUiState())
    val uiState = _uiState.asStateFlow()

    fun setGrossIncome(v: String) { _uiState.update { it.copy(grossIncome = v) } }
    fun setHraReceived(v: String) { _uiState.update { it.copy(hraReceived = v) } }
    fun setRentPaid(v: String) { _uiState.update { it.copy(rentPaid = v) } }
    fun setEpfContrib(v: String) { _uiState.update { it.copy(epfContrib = v) } }
    fun setOther80C(v: String) { _uiState.update { it.copy(other80C = v) } }
    fun setHealthInsurance(v: String) { _uiState.update { it.copy(healthInsurance = v) } }
    fun setNpsContrib(v: String) { _uiState.update { it.copy(npsContrib = v) } }
    fun setHomeLoanInterest(v: String) { _uiState.update { it.copy(homeLoanInterest = v) } }
    fun setIsMetro(v: Boolean) { _uiState.update { it.copy(isMetro = v) } }

    fun calculate() {
        val state = _uiState.value

        val gross = state.grossIncome.toLongOrNull() ?: 0L
        val hraReceived = state.hraReceived.toLongOrNull() ?: 0L
        val rentPaid = state.rentPaid.toLongOrNull() ?: 0L
        val epf = state.epfContrib.toLongOrNull() ?: 0L
        val other80C = state.other80C.toLongOrNull() ?: 0L
        val healthIns = state.healthInsurance.toLongOrNull() ?: 0L
        val nps = state.npsContrib.toLongOrNull() ?: 0L
        val homeLoan = state.homeLoanInterest.toLongOrNull() ?: 0L
        val basicSalary = gross * 40 / 100

        // HRA Exemption — minimum of 3 values
        val hraExemption = if (rentPaid > 0 && hraReceived > 0) {
            val opt1 = hraReceived
            val opt2 = rentPaid - (basicSalary * 10 / 100)
            val opt3 = if (state.isMetro) basicSalary * 50 / 100 else basicSalary * 40 / 100
            minOf(opt1, opt2, opt3).coerceAtLeast(0L)
        } else 0L

        // 80C — capped at 1.5 lakh
        val total80C = minOf(epf + other80C, 150000L)

        // 80D — capped at 25000
        val health80D = minOf(healthIns, 25000L)

        // NPS 80CCD(1B) — capped at 50000
        val nps80CCD = minOf(nps, 50000L)

        // Home loan 24(b) — capped at 2 lakh
        val homeLoan24b = minOf(homeLoan, 200000L)

        // Standard deduction
        val stdDeduction = 50000L

        // Old regime taxable income
        val totalDeductionsOld = stdDeduction + hraExemption + total80C + health80D + nps80CCD + homeLoan24b
        val taxableOld = (gross - totalDeductionsOld).coerceAtLeast(0L)
        val oldTax = calcOldRegimeTax(taxableOld)
        val oldTaxWithCess = if (taxableOld <= 500000L) 0L else oldTax * 104 / 100

        // New regime taxable income
        val taxableNew = (gross - 75000L).coerceAtLeast(0L)
        val newTax = calcNewRegimeTax(taxableNew)
        val newTaxWithCess = if (taxableNew <= 1200000L) 0L else newTax * 104 / 100

        val recommended = if (oldTaxWithCess <= newTaxWithCess) "Old Regime" else "New Regime"
        val saving = kotlin.math.abs(oldTaxWithCess - newTaxWithCess)

        val itrForm = when {
            gross > 5000000L -> "ITR-2"
            else -> "ITR-1 (Sahaj)"
        }

        _uiState.update {
            it.copy(
                showResults = true,
                oldRegimeTax = oldTaxWithCess,
                newRegimeTax = newTaxWithCess,
                recommended = recommended,
                saving = saving,
                standardDeduction = stdDeduction,
                hraExemption = hraExemption,
                total80C = total80C,
                health80D = health80D,
                nps80CCD = nps80CCD,
                homeLoan24b = homeLoan24b,
                totalDeductions = totalDeductionsOld,
                itrForm = itrForm
            )
        }
    }

    private fun calcOldRegimeTax(income: Long): Long = when {
        income <= 250000L -> 0L
        income <= 500000L -> (income - 250000L) * 5 / 100
        income <= 1000000L -> 12500L + (income - 500000L) * 20 / 100
        else -> 112500L + (income - 1000000L) * 30 / 100
    }

    private fun calcNewRegimeTax(income: Long): Long = when {
        income <= 400000L -> 0L
        income <= 800000L -> (income - 400000L) * 5 / 100
        income <= 1200000L -> 20000L + (income - 800000L) * 10 / 100
        income <= 1600000L -> 60000L + (income - 1200000L) * 15 / 100
        income <= 2000000L -> 120000L + (income - 1600000L) * 20 / 100
        income <= 2400000L -> 200000L + (income - 2000000L) * 25 / 100
        else -> 300000L + (income - 2400000L) * 30 / 100
    }
}