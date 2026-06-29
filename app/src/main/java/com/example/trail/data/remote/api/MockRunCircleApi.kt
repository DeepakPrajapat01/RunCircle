package com.example.trail.data.remote.api

import com.example.trail.data.remote.dto.*
import kotlinx.coroutines.delay
import javax.inject.Inject

class MockRunCircleApi @Inject constructor() : RunCircleApi {
    
    override suspend fun login(phone: String): Boolean {
        delay(1000); return true
    }

    override suspend fun verifyOtp(phone: String, otp: String): Boolean {
        delay(1000); return true
    }

    override suspend fun getNearbyRuns(city: String): List<RunDto> {
        delay(1000)
        return listOf(
            RunDto("1", "Morning Trail Run", "A fresh morning run through the park.", 5.0, "5:30", System.currentTimeMillis(), "06:30 AM", "Central Park", "u1", "Deepak", 12),
            RunDto("2", "Evening City Run", "Exploration run around the monuments.", 10.0, "6:00", System.currentTimeMillis(), "06:00 PM", "City Center", "u2", "Rahul", 8)
        )
    }

    override suspend fun getRun(id: String): RunDto {
        delay(500)
        return RunDto("1", "Morning Trail Run", "A fresh morning run through the park.", 5.0, "5:30", System.currentTimeMillis(), "06:30 AM", "Central Park", "u1", "Deepak", 12)
    }

    override suspend fun createRun(run: RunDto): Boolean {
        delay(1500); return true
    }

    override suspend fun joinRun(id: String): Boolean {
        delay(500); return true
    }

    override suspend fun getGroups(): List<GroupDto> {
        delay(1000)
        return listOf(
            GroupDto("1", "Jaipur Runners", "Community for Jaipur runners.", "Jaipur", 1200),
            GroupDto("2", "Trail Blazers", "Exploring trails together.", "Mumbai", 450)
        )
    }

    override suspend fun getGroup(id: String): GroupDto {
        delay(500)
        return GroupDto("1", "Jaipur Runners", "Community for Jaipur runners.", "Jaipur", 1200)
    }

    override suspend fun joinGroup(id: String): Boolean {
        delay(500); return true
    }

    override suspend fun getProfile(): UserDto {
        delay(1000)
        return UserDto("u1", "Arjun Mehta", "arjun@example.com", "911234567890", "Jaipur", "INTERMEDIATE", null, listOf("5K", "10K"), UserStatsDto(24, 120.5, 12))
    }

    override suspend fun getActivity(): List<RunDto> {
        delay(1000)
        return listOf(
            RunDto("1", "Morning Trail Run", "A fresh morning run through the park.", 5.0, "5:30", System.currentTimeMillis(), "06:30 AM", "Central Park", "u1", "Deepak", 12)
        )
    }
}
