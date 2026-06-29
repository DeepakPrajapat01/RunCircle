package com.example.trail.presentation.screens.group_details

import com.example.trail.domain.model.Group

data class GroupDetailsState(
    val isLoading: Boolean = false,
    val group: Group? = null,
    val error: String? = null,
    val isJoined: Boolean = false
)
