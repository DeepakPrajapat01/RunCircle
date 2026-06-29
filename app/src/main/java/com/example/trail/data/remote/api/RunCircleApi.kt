package com.example.trail.data.remote.api

import com.example.trail.data.remote.dto.*
import retrofit2.http.*

interface RunCircleApi {
    
    // Auth
    @POST("auth/login")
    suspend fun login(@Query("phone") phone: String): Boolean

    @POST("auth/verify")
    suspend fun verifyOtp(@Query("phone") phone: String, @Query("otp") otp: String): Boolean

    // Runs
    @GET("runs/nearby")
    suspend fun getNearbyRuns(@Query("city") city: String): List<RunDto>

    @GET("runs/{id}")
    suspend fun getRun(@Path("id") id: String): RunDto

    @POST("runs")
    suspend fun createRun(@Body run: RunDto): Boolean

    @POST("runs/{id}/join")
    suspend fun joinRun(@Path("id") id: String): Boolean

    // Groups
    @GET("groups")
    suspend fun getGroups(): List<GroupDto>

    @GET("groups/{id}")
    suspend fun getGroup(@Path("id") id: String): GroupDto

    @POST("groups/{id}/join")
    suspend fun joinGroup(@Path("id") id: String): Boolean

    // User
    @GET("user/profile")
    suspend fun getProfile(): UserDto

    @GET("user/activity")
    suspend fun getActivity(): List<RunDto>
}
