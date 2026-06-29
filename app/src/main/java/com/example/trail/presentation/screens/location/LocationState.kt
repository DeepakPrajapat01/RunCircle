package com.example.trail.presentation.screens.location

data class LocationState(
    val searchQuery: String = "",
    val popularCities: List<String> = listOf("Jaipur", "Ajmer", "Kekri", "Delhi", "Bangalore"),
    val selectedCity: String? = null,
    val isLoading: Boolean = false
)
