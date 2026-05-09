package com.arthsaarthi.presentation.investments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.Investment
import com.arthsaarthi.data.db.InvestmentDao
import com.arthsaarthi.utils.generateId
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class InvestmentsUiState(
    val investments: List<Investment> = emptyList(),
    val totalInvested: Long = 0L,
    val totalCurrentValue: Long = 0L
)

@HiltViewModel
class InvestmentsViewModel @Inject constructor(
    private val investmentDao: InvestmentDao
) : ViewModel() {

    val uiState: StateFlow<InvestmentsUiState> = combine(
        investmentDao.getAllInvestments(),
        investmentDao.getTotalInvested(),
        investmentDao.getTotalCurrentValue()
    ) { investments, invested, current ->
        InvestmentsUiState(investments = investments, totalInvested = invested, totalCurrentValue = current)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), InvestmentsUiState())

    fun addInvestment(type: String, name: String, investedPaise: Long, rate: Double, bank: String) {
        viewModelScope.launch {
            investmentDao.insert(
                Investment(
                    id = generateId(),
                    type = type,
                    name = name,
                    investedAmountPaise = investedPaise,
                    currentValuePaise = investedPaise, // starts at cost, user updates later
                    interestRate = rate,
                    bankName = bank
                )
            )
        }
    }

    fun delete(investment: Investment) {
        viewModelScope.launch { investmentDao.delete(investment) }
    }
}
