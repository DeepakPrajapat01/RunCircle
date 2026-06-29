package com.example.trail.data.repository

import com.example.trail.data.mapper.toDomain
import com.example.trail.data.remote.api.RunCircleApi
import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.RunRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRunRepository @Inject constructor(
    private val api: RunCircleApi
) : RunRepository {

    override fun getNearbyRuns(city: String): Flow<List<Run>> = flow {
        val result = api.getNearbyRuns(city)
        emit(result.map { it.toDomain() })
    }

    override fun getUpcomingRuns(): Flow<List<Run>> = flow {
        val result = api.getNearbyRuns("Jaipur")
        emit(result.map { it.toDomain() }.take(3))
    }

    override suspend fun getRunById(id: String): Run? {
        return api.getRun(id).toDomain()
    }

    override suspend fun createRun(run: Run): Boolean {
        // In real app, convert domain to DTO here
        return api.createRun(com.example.trail.data.remote.dto.RunDto(
            run.id, run.title, run.description, run.distance, run.pace, run.date.time, run.time, run.location, run.organizerId, run.organizerName, run.participantCount
        ))
    }

    override suspend fun joinRun(runId: String, userId: String): Boolean {
        return api.joinRun(runId)
    }
}
