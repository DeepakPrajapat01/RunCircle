package com.example.trail.presentation.screens.home

import com.example.trail.domain.model.Run

data class HomeState(
    val isLoading: Boolean = false,
    val nearbyRuns: List<Run> = emptyList(),
    val error: String? = null
)
