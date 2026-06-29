package com.example.trail.domain.repository

import com.example.trail.domain.model.Run
import kotlinx.coroutines.flow.Flow

interface RunRepository {
    fun getNearbyRuns(city: String): Flow<List<Run>>
    fun getUpcomingRuns(): Flow<List<Run>>
    suspend fun getRunById(id: String): Run?
    suspend fun joinRun(runId: String, userId: String): Boolean
    suspend fun createRun(run: Run): Boolean
}
