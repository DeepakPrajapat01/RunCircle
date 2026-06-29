package com.example.trail.presentation.screens.profile

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase
) : BaseViewModel<ProfileState>(ProfileState()) {

    init {
        getUser()
    }

    private fun getUser() {
        getCurrentUserUseCase().onEach { user ->
            _uiState.value = _uiState.value.copy(user = user)
        }.launchIn(viewModelScope)
    }
}
