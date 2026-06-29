package com.example.trail.presentation.screens.group_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetGroupByIdUseCase
import com.example.trail.domain.usecase.JoinGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupDetailsViewModel @Inject constructor(
    private val getGroupByIdUseCase: GetGroupByIdUseCase,
    private val joinGroupUseCase: JoinGroupUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<GroupDetailsState>(GroupDetailsState()) {

    private val groupId: String = checkNotNull(savedStateHandle["groupId"])

    init {
        getGroup()
    }

    private fun getGroup() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val group = getGroupByIdUseCase(groupId)
            _uiState.value = _uiState.value.copy(isLoading = false, group = group)
        }
    }

    fun onJoinClick() {
        viewModelScope.launch {
            val success = joinGroupUseCase(groupId, "current_user")
            if (success) {
                _uiState.value = _uiState.value.copy(isJoined = true)
            }
        }
    }
}
