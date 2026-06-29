package com.example.trail.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToOnboarding: () -> Unit) {
    val color = MaterialTheme.colorScheme.primary
    
    LaunchedEffect(key1 = true) {
        delay(2500)
        onNavigateToOnboarding()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // App Icon Placeholder (Professional Look)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color, shape = MaterialTheme.shapes.extraLarge),
                contentAlignment = Alignment.Center
            ) {
                Text("RC", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "RunCircle",
                style = MaterialTheme.typography.headlineLarge,
                color = color
            )
            Text(
                text = "Find your next run nearby.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
            )
        }

        // Get Started Button at bottom as in mockup
        Button(
            onClick = onNavigateToOnboarding,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
                .fillMaxWidth(0.8f)
                .height(56.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Get Started", style = MaterialTheme.typography.titleMedium)
        }
    }
}
