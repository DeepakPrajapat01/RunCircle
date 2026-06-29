package com.example.trail.domain.model

import java.util.Date

data class Run(
    val id: String,
    val title: String,
    val description: String,
    val distance: Double,
    val pace: String,
    val date: Date,
    val time: String,
    val location: String,
    val organizerId: String,
    val organizerName: String,
    val participants: List<String> = emptyList(),
    val participantCount: Int = 0
)
