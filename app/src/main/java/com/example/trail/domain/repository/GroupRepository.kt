package com.example.trail.domain.repository

import com.example.trail.domain.model.Group
import kotlinx.coroutines.flow.Flow

interface GroupRepository {
    fun getAllGroups(): Flow<List<Group>>
    suspend fun getGroupById(id: String): Group?
    suspend fun joinGroup(groupId: String, userId: String): Boolean
}
