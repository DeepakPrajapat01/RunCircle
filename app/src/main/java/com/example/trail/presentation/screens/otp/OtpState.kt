package com.example.trail.presentation.screens.otp

data class OtpState(
    val otp: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isVerificationSuccessful: Boolean = false
)
