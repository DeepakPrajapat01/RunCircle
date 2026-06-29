package com.example.trail.presentation.screens.notifications

import androidx.lifecycle.viewModelScope
import com.example.trail.core.base.BaseViewModel
import com.example.trail.domain.model.Notification
import com.example.trail.domain.model.NotificationType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor() : BaseViewModel<NotificationsState>(NotificationsState()) {

    init {
        getNotifications()
    }

    private fun getNotifications() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            delay(1000)
            val mockNotifications = listOf(
                Notification(
                    id = "1",
                    userId = "u1",
                    title = "New run nearby!",
                    body = "Jaipur Runners added a new 5K morning run.",
                    createdAt = Date(),
                    type = NotificationType.NEW_RUN_NEARBY,
                    isRead = false
                ),
                Notification(
                    id = "2",
                    userId = "u1",
                    title = "Welcome to RunCircle",
                    body = "Start your journey today by joining local groups.",
                    createdAt = Date(),
                    type = NotificationType.ACTIVITY_UPDATE,
                    isRead = true
                )
            )
            _uiState.value = _uiState.value.copy(isLoading = false, notifications = mockNotifications)
        }
    }
}
