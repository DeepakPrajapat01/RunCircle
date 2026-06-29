package com.example.trail.domain.model

enum class RunLevel {
    BEGINNER, INTERMEDIATE, ADVANCED
}

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val city: String,
    val level: RunLevel,
    val profileImage: String?,
    val interests: List<String> = emptyList(),
    val stats: UserStats = UserStats()
)

data class UserStats(
    val runsJoined: Int = 0,
    val totalKm: Double = 0.0,
    val streak: Int = 0
)
