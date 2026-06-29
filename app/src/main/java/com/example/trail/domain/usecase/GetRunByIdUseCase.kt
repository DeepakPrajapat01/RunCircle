package com.example.trail.domain.usecase

import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.RunRepository
import javax.inject.Inject

class GetRunByIdUseCase @Inject constructor(
    private val repository: RunRepository
) {
    suspend operator fun invoke(id: String): Run? {
        return repository.getRunById(id)
    }
}
