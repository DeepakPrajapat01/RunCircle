package com.example.trail.presentation.screens.run_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.presentation.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunDetailsScreen(
    onBack: () -> Unit,
    viewModel: RunDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Run Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            if (state.run != null) {
                Surface(tonalElevation = 8.dp) {
                    PrimaryButton(
                        text = if (state.joinSuccess) "Joined" else "Join Run",
                        onClick = viewModel::onJoinClick,
                        enabled = !state.isJoining && !state.joinSuccess,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    ) { padding ->
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            state.run?.let { run ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Mock Banner
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Icon(
                            Icons.Default.RunCircle,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp).align(Alignment.Center),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(text = run.title, style = MaterialTheme.typography.headlineMedium)
                        Text(
                            text = "Organized by ${run.organizerName}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        InfoRow(icon = Icons.Default.DateRange, text = "Tomorrow, 6:00 AM")
                        InfoRow(icon = Icons.Default.LocationOn, text = run.location)
                        InfoRow(icon = Icons.Default.ShowChart, text = "${run.distance} KM • ${run.pace}")

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(text = "About this run", style = MaterialTheme.typography.titleLarge)
                        Text(
                            text = run.description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "${run.participantCount} People Going",
                            style = MaterialTheme.typography.titleMedium
                        )
                        // Mock Avatar Row could go here
                    }
                }
            }
        }
    }
}

@Composable
fun InfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp), tint = MaterialTheme.colorScheme.secondary)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}
