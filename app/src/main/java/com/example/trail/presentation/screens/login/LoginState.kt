package com.example.trail.presentation.screens.login

data class LoginState(
    val phoneNumber: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLoginSuccessful: Boolean = false
)
