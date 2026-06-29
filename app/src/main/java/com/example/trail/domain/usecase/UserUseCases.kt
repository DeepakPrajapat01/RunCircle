package com.example.trail.domain.usecase

import com.example.trail.domain.model.User
import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Flow<User> = repository.getCurrentUser()
}

class GetUserActivityUseCase @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(): Flow<List<Run>> = repository.getUserActivity()
}
