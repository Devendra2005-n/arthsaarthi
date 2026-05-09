package com.arthsaarthi.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.*
import com.arthsaarthi.utils.getStartOfMonth
import kotlinx.coroutines.flow.*
import javax.inject.Inject

data class HomeUiState(
    val userName: String = "",
    val thisMonthSpend: Long = 0L,
    val thisMonthIncome: Long = 0L,
    val totalAssets: Long = 0L,
    val totalLoans: Long = 0L,
    val netWorth: Long = 0L,
    val recentTransactions: List<Transaction> = emptyList(),
    val topCategories: List<Pair<String, Long>> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val transactionDao: TransactionDao,
    private val userProfileDao: UserProfileDao,
    private val investmentDao: InvestmentDao,
    private val loanDao: LoanDao
) : ViewModel() {

    private val startOfMonth = getStartOfMonth()

    val uiState: StateFlow<HomeUiState> = combine(
        userProfileDao.getProfile(),
        transactionDao.getThisMonthTotalSpend(startOfMonth = startOfMonth),
        transactionDao.getThisMonthTotalIncome(startOfMonth = startOfMonth),
        transactionDao.getRecentTransactions(limit = 10),
        transactionDao.getTopCategories(startOfMonth = startOfMonth),
        investmentDao.getTotalCurrentValue(),
        loanDao.getTotalEmiPerMonth()
    ) { values ->
        val profile = values[0] as? UserProfile
        val spend = values[1] as? Long ?: 0L
        val income = values[2] as? Long ?: 0L
        @Suppress("UNCHECKED_CAST")
        val recent = values[3] as? List<Transaction> ?: emptyList()
        @Suppress("UNCHECKED_CAST")
        val topCats = values[4] as? List<CategoryTotal> ?: emptyList()
        val investValue = values[5] as? Long ?: 0L
        val totalEmi = values[6] as? Long ?: 0L

        HomeUiState(
            userName = profile?.name ?: "Friend",
            thisMonthSpend = spend,
            thisMonthIncome = income,
            totalAssets = investValue,
            totalLoans = totalEmi * 12,
            netWorth = investValue - (totalEmi * 12),
            recentTransactions = recent,
            topCategories = topCats.map { it.category to it.total }
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState()
    )
}
