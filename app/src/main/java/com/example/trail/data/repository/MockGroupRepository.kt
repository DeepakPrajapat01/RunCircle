package com.example.trail.data.repository

import com.example.trail.domain.model.Group
import com.example.trail.domain.repository.GroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MockGroupRepository @Inject constructor() : GroupRepository {
    private val mockGroups = listOf(
        Group("1", "Jaipur Runners Club", "A community of passionate runners in Jaipur. All are welcome!", "Jaipur", 1200, upcomingRuns = listOf("1")),
        Group("2", "Pink City Runners", "Leading running group in the heart of Jaipur.", "Jaipur", 850),
        Group("3", "Ajmer Marathoners", "Preparing for the biggest runs in Rajasthan.", "Ajmer", 450),
        Group("4", "Trail Runners Jaipur", "Exploring the Aravalis together.", "Jaipur", 300)
    )

    override fun getAllGroups(): Flow<List<Group>> = flow {
        emit(mockGroups)
    }

    override suspend fun getGroupById(id: String): Group? = mockGroups.find { it.id == id }

    override suspend fun joinGroup(groupId: String, userId: String): Boolean = true
}
