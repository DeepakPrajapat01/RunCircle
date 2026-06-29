package com.example.trail.domain.model

data class Group(
    val id: String,
    val name: String,
    val description: String,
    val city: String,
    val memberCount: Int = 0,
    val bannerImage: String? = null,
    val upcomingRuns: List<String> = emptyList()
)
