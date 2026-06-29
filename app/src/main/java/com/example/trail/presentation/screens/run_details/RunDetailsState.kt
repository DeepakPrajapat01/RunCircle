package com.example.trail.presentation.screens.run_details

import com.example.trail.domain.model.Run

data class RunDetailsState(
    val isLoading: Boolean = false,
    val run: Run? = null,
    val error: String? = null,
    val isJoining: Boolean = false,
    val joinSuccess: Boolean = false
)
