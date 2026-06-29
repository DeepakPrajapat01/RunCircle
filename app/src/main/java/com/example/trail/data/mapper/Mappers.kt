package com.example.trail.data.mapper

import com.example.trail.data.remote.dto.*
import com.example.trail.domain.model.*
import java.util.Date

fun UserDto.toDomain(): User = User(
    id = id,
    name = name,
    email = email,
    phone = phone,
    city = city,
    level = RunLevel.valueOf(level),
    profileImage = profileImage,
    interests = interests,
    stats = stats.toDomain()
)

fun UserStatsDto.toDomain(): UserStats = UserStats(
    runsJoined = runsJoined,
    totalKm = totalKm,
    streak = streak
)

fun RunDto.toDomain(): Run = Run(
    id = id,
    title = title,
    description = description,
    distance = distance,
    pace = pace,
    date = Date(date),
    time = time,
    location = location,
    organizerId = organizerId,
    organizerName = organizerName,
    participantCount = participantCount
)

fun GroupDto.toDomain(): Group = Group(
    id = id,
    name = name,
    description = description,
    city = city,
    memberCount = memberCount,
    upcomingRuns = upcomingRuns
)
