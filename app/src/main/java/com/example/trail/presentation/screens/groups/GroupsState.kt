package com.example.trail.presentation.screens.groups

import com.example.trail.domain.model.Group

data class GroupsState(
    val isLoading: Boolean = false,
    val groups: List<Group> = emptyList(),
    val error: String? = null
)
