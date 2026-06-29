package com.example.trail.domain.repository

import com.example.trail.domain.model.User
import com.example.trail.domain.model.Run
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getCurrentUser(): Flow<User>
    fun getUserActivity(): Flow<List<Run>>
}
