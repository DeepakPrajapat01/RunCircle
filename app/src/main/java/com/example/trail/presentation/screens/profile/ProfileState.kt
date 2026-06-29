package com.example.trail.presentation.screens.profile

import com.example.trail.domain.model.User

data class ProfileState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String? = null
)
