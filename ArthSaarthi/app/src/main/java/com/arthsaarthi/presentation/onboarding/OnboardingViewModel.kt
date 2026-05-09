package com.arthsaarthi.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.UserProfile
import com.arthsaarthi.data.db.UserProfileDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OnboardingUiState(
    val currentStep: Int = 0,
    val language: String = "en",
    val incomeType: String = "",
    val cityTier: String = "",
    val name: String = "",
    val isComplete: Boolean = false
)

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val userProfileDao: UserProfileDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState = _uiState.asStateFlow()

    init {
        checkOnboardingStatus()
    }

    private fun checkOnboardingStatus() {
        viewModelScope.launch {
            val profile = userProfileDao.getProfileOnce()
            if (profile?.isOnboardingDone == true) {
                _uiState.update { it.copy(isComplete = true) }
            }
        }
    }

    fun nextStep() {
        _uiState.update { it.copy(currentStep = it.currentStep + 1) }
    }

    fun setLanguage(lang: String) {
        _uiState.update { it.copy(language = lang) }
    }

    fun setIncomeType(type: String) {
        _uiState.update { it.copy(incomeType = type) }
    }

    fun setCityTier(tier: String) {
        _uiState.update { it.copy(cityTier = tier) }
    }

    fun setName(name: String) {
        _uiState.update { it.copy(name = name) }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            val state = _uiState.value
            val profile = UserProfile(
                id = "default_user",
                name = state.name,
                incomeType = state.incomeType.ifEmpty { "SALARIED" },
                cityTier = state.cityTier.ifEmpty { "TIER2" },
                preferredLanguage = state.language,
                isOnboardingDone = true
            )
            userProfileDao.insert(profile)
            _uiState.update { it.copy(isComplete = true) }
        }
    }
}
