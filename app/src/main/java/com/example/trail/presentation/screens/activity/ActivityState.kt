package com.example.trail.presentation.screens.activity

import com.example.trail.domain.model.Run

data class ActivityState(
    val isLoading: Boolean = false,
    val activities: List<Run> = emptyList(),
    val error: String? = null
)
