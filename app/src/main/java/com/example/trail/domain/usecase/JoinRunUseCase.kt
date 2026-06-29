package com.example.trail.domain.usecase

import com.example.trail.domain.repository.RunRepository
import javax.inject.Inject

class JoinRunUseCase @Inject constructor(
    private val repository: RunRepository
) {
    suspend operator fun invoke(runId: String, userId: String): Boolean {
        return repository.joinRun(runId, userId)
    }
}
