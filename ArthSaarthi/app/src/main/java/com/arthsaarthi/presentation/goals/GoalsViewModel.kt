package com.arthsaarthi.presentation.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.Goal
import com.arthsaarthi.data.db.GoalDao
import com.arthsaarthi.utils.generateId
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

data class GoalsUiState(val goals: List<Goal> = emptyList())

@HiltViewModel
class GoalsViewModel @Inject constructor(private val goalDao: GoalDao) : ViewModel() {

    val uiState: StateFlow<GoalsUiState> = goalDao.getActiveGoals()
        .map { GoalsUiState(goals = it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), GoalsUiState())

    fun addGoal(name: String, type: String, targetPaise: Long, years: Int) {
        viewModelScope.launch {
            val deadline = Calendar.getInstance().apply { add(Calendar.YEAR, years) }.timeInMillis
            goalDao.insert(Goal(id = generateId(), name = name, goalType = type, targetAmountPaise = targetPaise, deadlineMillis = deadline))
        }
    }

    fun delete(goal: Goal) { viewModelScope.launch { goalDao.delete(goal) } }
}
