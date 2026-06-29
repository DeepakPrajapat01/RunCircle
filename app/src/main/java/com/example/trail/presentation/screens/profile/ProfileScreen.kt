package com.example.trail.presentation.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.presentation.components.AchievementCard
import com.example.trail.presentation.components.ProfileHeader

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        state.user?.let { user ->
            ProfileHeader(user = user)

            Column(modifier = Modifier.padding(24.dp)) {
                Text("Achievements", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    item { AchievementCard("Early Bird", "5 runs before 7am", Icons.Default.Star) }
                    item { AchievementCard("Distance Pro", "100km total", Icons.Default.WorkspacePremium) }
                    item { AchievementCard("Streak Master", "10 day streak", Icons.Default.Star) }
                }

                Spacer(modifier = Modifier.height(32.dp))
                Text("Your Interests", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    user.interests.forEach { interest ->
                        SuggestionChip(onClick = {}, label = { Text(interest) })
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRow(horizontalArrangement: Arrangement.Horizontal, content: @Composable () -> Unit) {
    androidx.compose.foundation.layout.FlowRow(horizontalArrangement = horizontalArrangement) {
        content()
    }
}
