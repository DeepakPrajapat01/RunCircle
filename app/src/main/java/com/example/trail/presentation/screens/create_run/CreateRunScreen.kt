package com.example.trail.presentation.screens.create_run

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.presentation.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRunScreen(
    onBack: () -> Unit,
    onSuccess: () -> Unit,
    viewModel: CreateRunViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    if (state.isSuccess) {
        onSuccess()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create a New Run") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Bring your running community together.", style = MaterialTheme.typography.bodyLarge)

            OutlinedTextField(
                value = state.title,
                onValueChange = viewModel::onTitleChange,
                label = { Text("Run Title") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("e.g. Sunday Long Run") }
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = state.distance,
                    onValueChange = viewModel::onDistanceChange,
                    label = { Text("Distance (KM)") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = state.pace,
                    onValueChange = viewModel::onPaceChange,
                    label = { Text("Pace") },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("e.g. 5:30") }
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = state.date,
                    onValueChange = viewModel::onDateChange,
                    label = { Text("Date") },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Select Date") }
                )
                OutlinedTextField(
                    value = state.time,
                    onValueChange = viewModel::onTimeChange,
                    label = { Text("Time") },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Select Time") }
                )
            }

            OutlinedTextField(
                value = state.location,
                onValueChange = viewModel::onLocationChange,
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Select Location") }
            )

            OutlinedTextField(
                value = state.description,
                onValueChange = viewModel::onDescriptionChange,
                label = { Text("Description (Optional)") },
                modifier = Modifier.fillMaxWidth().height(120.dp),
                placeholder = { Text("Add any details about your run...") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                text = "Create Run",
                onClick = viewModel::onCreateClick,
                enabled = state.title.isNotBlank() && !state.isLoading
            )

            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
