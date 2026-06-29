package com.example.trail.domain.model

import java.util.Date

data class Notification(
    val id: String,
    val userId: String,
    val title: String,
    val body: String,
    val createdAt: Date,
    val isRead: Boolean = false,
    val type: NotificationType
)

enum class NotificationType {
    RUN_REMINDER, GROUP_INVITATION, NEW_RUN_NEARBY, ACTIVITY_UPDATE
}
