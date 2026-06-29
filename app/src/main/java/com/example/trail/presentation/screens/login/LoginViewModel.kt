package com.example.trail.presentation.screens.login

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel<LoginState>(LoginState()) {

    fun onPhoneNumberChange(newValue: String) {
        _uiState.value = _uiState.value.copy(phoneNumber = newValue)
    }

    fun onContinueClick() {
        if (_uiState.value.phoneNumber.length >= 10) {
            viewModelScope.launch {
                _uiState.value = _uiState.value.copy(isLoading = true)
                delay(1500) // Mock network delay
                _uiState.value = _uiState.value.copy(isLoading = false, isLoginSuccessful = true)
            }
        }
    }
}
