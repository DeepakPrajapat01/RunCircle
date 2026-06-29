package com.example.trail.domain.usecase

import com.example.trail.domain.model.Group
import com.example.trail.domain.repository.GroupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllGroupsUseCase @Inject constructor(private val repository: GroupRepository) {
    operator fun invoke(): Flow<List<Group>> = repository.getAllGroups()
}

class GetGroupByIdUseCase @Inject constructor(private val repository: GroupRepository) {
    suspend operator fun invoke(id: String): Group? = repository.getGroupById(id)
}

class JoinGroupUseCase @Inject constructor(private val repository: GroupRepository) {
    suspend operator fun invoke(groupId: String, userId: String): Boolean = repository.joinGroup(groupId, userId)
}
