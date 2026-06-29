package com.example.trail.data.di

import com.example.trail.data.repository.NetworkGroupRepository
import com.example.trail.data.repository.NetworkRunRepository
import com.example.trail.data.repository.NetworkUserRepository
import com.example.trail.domain.repository.GroupRepository
import com.example.trail.domain.repository.RunRepository
import com.example.trail.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRunRepository(
        networkRunRepository: NetworkRunRepository
    ): RunRepository

    @Binds
    @Singleton
    abstract fun bindGroupRepository(
        networkGroupRepository: NetworkGroupRepository
    ): GroupRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        networkUserRepository: NetworkUserRepository
    ): UserRepository
}
