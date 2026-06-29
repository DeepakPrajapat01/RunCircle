package com.example.trail.domain.usecase

import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.RunRepository
import javax.inject.Inject

class CreateRunUseCase @Inject constructor(
    private val repository: RunRepository
) {
    suspend operator fun invoke(run: Run): Boolean {
        return repository.createRun(run)
    }
}
