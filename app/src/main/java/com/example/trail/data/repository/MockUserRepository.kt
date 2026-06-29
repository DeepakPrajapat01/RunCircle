package com.example.trail.data.repository

import com.example.trail.domain.model.User
import com.example.trail.domain.model.Run
import com.example.trail.domain.model.RunLevel
import com.example.trail.domain.model.UserStats
import com.example.trail.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class MockUserRepository @Inject constructor() : UserRepository {
    private val mockUser = User(
        id = "current_user",
        name = "Arjun Mehta",
        email = "arjun@example.com",
        phone = "911234567890",
        city = "Jaipur",
        level = RunLevel.INTERMEDIATE,
        profileImage = null,
        interests = listOf("5K Runs", "10K Runs", "Marathon"),
        stats = UserStats(runsJoined = 24, totalKm = 120.4, streak = 12)
    )

    override fun getCurrentUser(): Flow<User> = flow {
        emit(mockUser)
    }

    override fun getUserActivity(): Flow<List<Run>> = flow {
        emit(listOf(
            Run("101", "5K Morning Run", "Quick morning jog", 5.0, "6:00", Date(), "08:30 AM", "Jaipur", "user1", "Jaipur Runners"),
            Run("102", "Sunday Long Run", "Weekly endurance", 12.0, "5:45", Date(), "07:00 AM", "Jaipur", "user2", "Pink City Runners")
        ))
    }
}
