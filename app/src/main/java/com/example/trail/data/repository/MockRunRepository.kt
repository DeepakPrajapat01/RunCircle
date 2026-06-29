package com.example.trail.data.repository

import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.RunRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class MockRunRepository @Inject constructor() : RunRepository {
    private val mockRuns = mutableListOf(
        Run("1", "5K Morning Run ☀️", "Start your day with a refreshing 5K run.", 5.0, "6:00", Date(), "6:00 AM", "Central Park, Jaipur", "user1", "Jaipur Runners Club", participantCount = 16),
        Run("2", "Sunday Long Run 🏃", "Weekly long run for marathon training.", 15.0, "5:30", Date(), "7:00 AM", "Jawahar Circle, Jaipur", "user2", "Pink City Runners", participantCount = 8),
        Run("3", "College Campus Run 🎓", "Quick run around the campus.", 3.0, "6:30", Date(), "5:30 PM", "MNIT, Jaipur", "user3", "Student Runners", participantCount = 12)
    )

    override fun getNearbyRuns(city: String): Flow<List<Run>> = flow {
        emit(mockRuns)
    }

    override fun getUpcomingRuns(): Flow<List<Run>> = flow {
        emit(mockRuns.take(2))
    }

    override suspend fun getRunById(id: String): Run? = mockRuns.find { it.id == id }

    override suspend fun joinRun(runId: String, userId: String): Boolean {
        // Mock logic: check if already joined, then add
        return true
    }

    override suspend fun createRun(run: Run): Boolean {
        mockRuns.add(run)
        return true
    }
}
