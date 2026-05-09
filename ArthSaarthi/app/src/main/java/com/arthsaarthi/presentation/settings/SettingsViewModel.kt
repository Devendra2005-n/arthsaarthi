package com.arthsaarthi.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.arthsaarthi.data.db.UserProfileDao
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val name: String = "",
    val incomeType: String = "",
    val state: String = "",
    val language: String = "en"
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userProfileDao: UserProfileDao
) : ViewModel() {

    val uiState: StateFlow<SettingsUiState> = userProfileDao.getProfile()
        .map { profile ->
            SettingsUiState(
                name = profile?.name ?: "",
                incomeType = profile?.incomeType ?: "",
                state = profile?.state ?: "",
                language = profile?.preferredLanguage ?: "en"
            )
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SettingsUiState())

    fun setLanguage(lang: String) {
        viewModelScope.launch {
            val profile = userProfileDao.getProfileOnce() ?: return@launch
            userProfileDao.update(profile.copy(preferredLanguage = lang))
        }
    }
}
