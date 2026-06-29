package com.example.trail.presentation.screens.groups

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.usecase.GetAllGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val getAllGroupsUseCase: GetAllGroupsUseCase
) : BaseViewModel<GroupsState>(GroupsState()) {

    init {
        getGroups()
    }

    private fun getGroups() {
        getAllGroupsUseCase().onEach { groups ->
            _uiState.value = _uiState.value.copy(groups = groups)
        }.launchIn(viewModelScope)
    }
}
