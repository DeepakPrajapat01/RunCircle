package com.example.trail.presentation.screens.run_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetRunByIdUseCase
import com.example.trail.domain.usecase.JoinRunUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RunDetailsViewModel @Inject constructor(
    private val getRunByIdUseCase: GetRunByIdUseCase,
    private val joinRunUseCase: JoinRunUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<RunDetailsState>(RunDetailsState()) {

    private val runId: String = checkNotNull(savedStateHandle["runId"])

    init {
        getRunDetails()
    }

    private fun getRunDetails() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val result = getRunByIdUseCase(runId)
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                run = result
            )
        }
    }

    fun onJoinClick() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isJoining = true)
            val success = joinRunUseCase(runId, "current_user_id")
            _uiState.value = _uiState.value.copy(
                isJoining = false,
                joinSuccess = success
            )
        }
    }
}
