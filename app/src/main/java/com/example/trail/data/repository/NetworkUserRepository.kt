package com.example.trail.data.repository

import com.example.trail.data.mapper.toDomain
import com.example.trail.data.remote.api.RunCircleApi
import com.example.trail.domain.model.User
import com.example.trail.domain.model.Run
import com.example.trail.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkUserRepository @Inject constructor(
    private val api: RunCircleApi
) : UserRepository {

    override fun getCurrentUser(): Flow<User> = flow {
        val result = api.getProfile()
        emit(result.toDomain())
    }

    override fun getUserActivity(): Flow<List<Run>> = flow {
        val result = api.getActivity()
        emit(result.map { it.toDomain() })
    }
}
