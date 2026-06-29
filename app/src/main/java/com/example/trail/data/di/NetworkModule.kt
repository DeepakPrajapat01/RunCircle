package com.example.trail.data.di

import com.example.trail.data.remote.api.RunCircleApi
import com.example.trail.data.remote.api.MockRunCircleApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindRunCircleApi(
        mockApi: MockRunCircleApi
    ): RunCircleApi
}
