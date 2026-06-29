package com.example.trail.presentation.screens.group_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.presentation.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupDetailsScreen(
    onBack: () -> Unit,
    viewModel: GroupDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Group Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        state.group?.let { group ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth().height(180.dp).background(MaterialTheme.colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Groups, contentDescription = null, modifier = Modifier.size(80.dp), tint = MaterialTheme.colorScheme.onSecondaryContainer)
                }
                
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(text = group.name, style = MaterialTheme.typography.headlineMedium, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                    Text(text = "${group.memberCount} Members • ${group.city}", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(text = "About", style = MaterialTheme.typography.titleLarge)
                    Text(text = group.description, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 8.dp))
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    PrimaryButton(
                        text = if (state.isJoined) "Joined" else "Join Group",
                        onClick = viewModel::onJoinClick,
                        enabled = !state.isJoined
                    )
                }
            }
        }
    }
}
