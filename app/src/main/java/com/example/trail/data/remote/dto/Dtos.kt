package com.example.trail.data.remote.dto

import java.util.Date

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val city: String,
    val level: String,
    val profileImage: String?,
    val interests: List<String>,
    val stats: UserStatsDto
)

data class UserStatsDto(
    val runsJoined: Int,
    val totalKm: Double,
    val streak: Int
)

data class RunDto(
    val id: String,
    val title: String,
    val description: String,
    val distance: Double,
    val pace: String,
    val date: Long, // timestamp
    val time: String,
    val location: String,
    val organizerId: String,
    val organizerName: String,
    val participantCount: Int
)

data class GroupDto(
    val id: String,
    val name: String,
    val description: String,
    val city: String,
    val memberCount: Int,
    val upcomingRuns: List<String> = emptyList()
)
