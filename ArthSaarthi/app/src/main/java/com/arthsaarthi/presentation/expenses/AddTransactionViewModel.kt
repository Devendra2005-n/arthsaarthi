package com.arthsaarthi.presentation.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.Transaction
import com.arthsaarthi.data.db.TransactionDao
import com.arthsaarthi.utils.generateId
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddTransactionUiState(
    val type: String = "EXPENSE",
    val amountDisplay: String = "",
    val category: String = "",
    val paymentMode: String = "Cash",
    val merchantName: String = "",
    val note: String = "",
    val isSaved: Boolean = false
)

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val transactionDao: TransactionDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddTransactionUiState())
    val uiState = _uiState.asStateFlow()

    fun setType(type: String) { _uiState.update { it.copy(type = type, category = "") } }
    fun setCategory(cat: String) { _uiState.update { it.copy(category = cat) } }
    fun setPaymentMode(mode: String) { _uiState.update { it.copy(paymentMode = mode) } }
    fun setMerchant(v: String) { _uiState.update { it.copy(merchantName = v) } }
    fun setNote(v: String) { _uiState.update { it.copy(note = v) } }

    fun appendDigit(digit: String) {
        val current = _uiState.value.amountDisplay
        if (digit == "." && current.contains(".")) return
        if (current.length >= 10) return
        _uiState.update { it.copy(amountDisplay = current + digit) }
    }

    fun backspace() {
        val current = _uiState.value.amountDisplay
        if (current.isNotEmpty()) {
            _uiState.update { it.copy(amountDisplay = current.dropLast(1)) }
        }
    }

    fun setAmountFromPaise(paise: Long) {
        val rupees = paise / 100
        _uiState.update { it.copy(amountDisplay = rupees.toString()) }
    }

    fun save() {
        val state = _uiState.value
        val amountPaise = (state.amountDisplay.toDoubleOrNull() ?: return) * 100
        if (amountPaise <= 0) return
        if (state.category.isEmpty()) return

        viewModelScope.launch {
            transactionDao.insert(
                Transaction(
                    id = generateId(),
                    amountPaise = amountPaise.toLong(),
                    type = state.type,
                    category = state.category,
                    paymentMode = state.paymentMode,
                    merchantName = state.merchantName,
                    note = state.note,
                    source = "MANUAL"
                )
            )
            _uiState.update { it.copy(isSaved = true) }
        }
    }
}
