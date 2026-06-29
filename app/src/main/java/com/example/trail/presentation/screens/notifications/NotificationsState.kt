package com.example.trail.presentation.screens.notifications

import com.example.trail.domain.model.Notification

data class NotificationsState(
    val isLoading: Boolean = false,
    val notifications: List<Notification> = emptyList(),
    val error: String? = null
)
