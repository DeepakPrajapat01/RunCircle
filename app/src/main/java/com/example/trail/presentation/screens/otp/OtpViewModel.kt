package com.example.trail.presentation.screens.otp

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor() : BaseViewModel<OtpState>(OtpState()) {

    fun onOtpChange(newValue: String) {
        if (newValue.length <= 6) {
            _uiState.value = _uiState.value.copy(otp = newValue)
        }
    }

    fun onVerifyClick() {
        if (_uiState.value.otp.length == 6) {
            viewModelScope.launch {
                _uiState.value = _uiState.value.copy(isLoading = true)
                delay(1500)
                _uiState.value = _uiState.value.copy(isLoading = false, isVerificationSuccessful = true)
            }
        }
    }
}
