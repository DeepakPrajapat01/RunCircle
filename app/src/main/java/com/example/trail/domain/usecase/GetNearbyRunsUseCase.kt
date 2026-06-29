package com.example.trail.domain.usecase

import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.RunRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNearbyRunsUseCase @Inject constructor(
    private val repository: RunRepository
) {
    operator fun invoke(city: String): Flow<List<Run>> {
        return repository.getNearbyRuns(city)
    }
}
