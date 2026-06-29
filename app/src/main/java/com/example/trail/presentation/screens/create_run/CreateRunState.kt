package com.example.trail.presentation.screens.create_run

data class CreateRunState(
    val title: String = "",
    val description: String = "",
    val distance: String = "",
    val pace: String = "",
    val date: String = "",
    val time: String = "",
    val location: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)
