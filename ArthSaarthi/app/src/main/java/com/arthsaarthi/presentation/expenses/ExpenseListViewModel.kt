package com.arthsaarthi.presentation.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.Transaction
import com.arthsaarthi.data.db.TransactionDao
import com.arthsaarthi.utils.getStartOfMonth
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ExpenseListUiState(
    val transactions: List<Transaction> = emptyList(),
    val totalSpend: Long = 0L,
    val totalIncome: Long = 0L
)

@HiltViewModel
class ExpenseListViewModel @Inject constructor(
    private val transactionDao: TransactionDao
) : ViewModel() {

    private val startOfMonth = getStartOfMonth()

    val uiState: StateFlow<ExpenseListUiState> = combine(
        transactionDao.getAllTransactions(),
        transactionDao.getThisMonthTotalSpend(startOfMonth = startOfMonth),
        transactionDao.getThisMonthTotalIncome(startOfMonth = startOfMonth)
    ) { transactions, spend, income ->
        ExpenseListUiState(
            transactions = transactions,
            totalSpend = spend,
            totalIncome = income
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ExpenseListUiState())

    fun delete(id: String) {
        viewModelScope.launch { transactionDao.softDelete(id) }
    }
}
