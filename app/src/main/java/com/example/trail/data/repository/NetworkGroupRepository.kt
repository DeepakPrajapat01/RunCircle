package com.example.trail.data.repository

import com.example.trail.data.mapper.toDomain
import com.example.trail.data.remote.api.RunCircleApi
import com.example.trail.domain.model.Group
import com.example.trail.domain.repository.GroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkGroupRepository @Inject constructor(
    private val api: RunCircleApi
) : GroupRepository {

    override fun getAllGroups(): Flow<List<Group>> = flow {
        val result = api.getGroups()
        emit(result.map { it.toDomain() })
    }

    override suspend fun getGroupById(id: String): Group? {
        return api.getGroup(id).toDomain()
    }

    override suspend fun joinGroup(groupId: String, userId: String): Boolean {
        return api.joinGroup(groupId)
    }
}
