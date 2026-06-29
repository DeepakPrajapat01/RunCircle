package com.example.trail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Reusable Components Checklist for Run Circle:
 * 1. PrimaryButton - Custom green button
 * 2. SecondaryButton - Outlined button for secondary actions
 * 3. RunCard - Displays run info in lists
 * 4. GroupCard - Displays group info in lists
 * 5. InterestChip - Filter/Selection chips
 * 6. CustomTextField - Styled inputs
 * 7. ParticipantAvatarRow - Row of small avatars
 * 8. RunStatItem - Individual stat (Distance, Pace, Time) displays
 */

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(56.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = text, style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun RunCard(
    run: com.example.trail.domain.model.Run,
    onJoinClick: () -> Unit,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClick,
        modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = run.title, style = MaterialTheme.typography.titleLarge)
                    Text(text = run.location, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.secondary)
                }
                Text(text = run.time, style = MaterialTheme.typography.labelLarge)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Text(text = "${run.distance} KM • ${run.participantCount} Going", style = MaterialTheme.typography.bodyMedium)
                Button(onClick = onJoinClick, shape = MaterialTheme.shapes.small) {
                    Text("Join")
                }
            }
        }
    }
}
