package com.example.trail.presentation.screens.create_run

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.model.Run
import com.example.trail.domain.usecase.CreateRunUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateRunViewModel @Inject constructor(
    private val createRunUseCase: CreateRunUseCase
) : BaseViewModel<CreateRunState>(CreateRunState()) {

    fun onTitleChange(value: String) { _uiState.value = _uiState.value.copy(title = value) }
    fun onDescriptionChange(value: String) { _uiState.value = _uiState.value.copy(description = value) }
    fun onDistanceChange(value: String) { _uiState.value = _uiState.value.copy(distance = value) }
    fun onPaceChange(value: String) { _uiState.value = _uiState.value.copy(pace = value) }
    fun onDateChange(value: String) { _uiState.value = _uiState.value.copy(date = value) }
    fun onTimeChange(value: String) { _uiState.value = _uiState.value.copy(time = value) }
    fun onLocationChange(value: String) { _uiState.value = _uiState.value.copy(location = value) }

    fun onCreateClick() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val newRun = Run(
                id = UUID.randomUUID().toString(),
                title = _uiState.value.title,
                description = _uiState.value.description,
                distance = _uiState.value.distance.toDoubleOrNull() ?: 0.0,
                pace = _uiState.value.pace,
                date = Date(), // Mock date
                time = _uiState.value.time,
                location = _uiState.value.location,
                organizerId = "current_user",
                organizerName = "You",
                participantCount = 1
            )
            val success = createRunUseCase(newRun)
            _uiState.value = _uiState.value.copy(isLoading = false, isSuccess = success)
        }
    }
}
