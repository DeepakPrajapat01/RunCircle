package com.example.trail.presentation.screens.interest

import com.example.trail.domain.model.RunLevel

data class InterestState(
    val selectedLevel: RunLevel? = null,
    val selectedInterests: Set<String> = emptySet(),
    val availableInterests: List<String> = listOf(
        "5K Runs", "10K Runs", "Half Marathon", "Marathon", 
        "Trail Running", "Speed Training", "Long Distance", "Fun Runs"
    )
)
