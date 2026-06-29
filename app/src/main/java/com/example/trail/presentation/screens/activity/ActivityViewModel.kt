package com.example.trail.presentation.screens.activity

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetUserActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val getUserActivityUseCase: GetUserActivityUseCase
) : BaseViewModel<ActivityState>(ActivityState()) {

    init {
        getActivity()
    }

    private fun getActivity() {
        getUserActivityUseCase().onEach { activities ->
            _uiState.value = _uiState.value.copy(activities = activities)
        }.launchIn(viewModelScope)
    }
}
