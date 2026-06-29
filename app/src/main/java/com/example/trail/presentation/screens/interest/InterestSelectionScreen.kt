package com.example.trail.presentation.screens.interest

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.domain.model.RunLevel
import com.example.trail.presentation.components.PrimaryButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterestSelectionScreen(
    onComplete: () -> Unit,
    viewModel: InterestViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Tell us about you",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 48.dp)
        )
        Text(
            text = "Select your running level and interests.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        Text(
            text = "Running Level",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RunLevel.entries.forEach { level ->
                val selected = state.selectedLevel == level
                FilterChip(
                    selected = selected,
                    onClick = { viewModel.onLevelSelect(level) },
                    label = { Text(level.name.lowercase().replaceFirstChar { it.uppercase() }) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Interests (Select all that apply)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            state.availableInterests.forEach { interest ->
                val selected = state.selectedInterests.contains(interest)
                FilterChip(
                    selected = selected,
                    onClick = { viewModel.onInterestToggle(interest) },
                    label = { Text(interest) }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = "Continue",
            onClick = onComplete,
            enabled = state.selectedLevel != null && state.selectedInterests.isNotEmpty(),
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}
