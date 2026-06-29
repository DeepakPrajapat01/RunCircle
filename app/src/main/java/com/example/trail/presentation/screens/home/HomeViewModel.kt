package com.example.trail.presentation.screens.home

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetNearbyRunsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNearbyRunsUseCase: GetNearbyRunsUseCase
) : BaseViewModel<HomeState>(HomeState()) {

    init {
        getNearbyRuns()
    }

    private fun getNearbyRuns() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        getNearbyRunsUseCase("Jaipur").onEach { runs ->
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                nearbyRuns = runs
            )
        }.launchIn(viewModelScope)
    }
}
