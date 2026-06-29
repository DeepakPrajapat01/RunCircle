package com.example.trail.presentation.screens.interest

import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.model.RunLevel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterestViewModel @Inject constructor() : BaseViewModel<InterestState>(InterestState()) {

    fun onLevelSelect(level: RunLevel) {
        _uiState.value = _uiState.value.copy(selectedLevel = level)
    }

    fun onInterestToggle(interest: String) {
        val current = _uiState.value.selectedInterests
        val updated = if (current.contains(interest)) {
            current - interest
        } else {
            current + interest
        }
        _uiState.value = _uiState.value.copy(selectedInterests = updated)
    }
}
