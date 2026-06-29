package com.example.trail.presentation.theme

import androidx.compose.ui.graphics.Color

val PrimaryGreen = Color(0xFF4CAF50)
val PrimaryDarkGreen = Color(0xFF388E3C)
val SecondaryGreen = Color(0xFF81C784)
val AccentOrange = Color(0xFFFF9800)
val BackgroundDark = Color(0xFF121212)
val SurfaceDark = Color(0xFF1E1E1E)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFB0B0B0)
val ErrorRed = Color(0xFFCF6679)

val DarkColorScheme = androidx.compose.material3.darkColorScheme(
    primary = PrimaryGreen,
    secondary = SecondaryGreen,
    tertiary = AccentOrange,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    error = ErrorRed
)

val LightColorScheme = androidx.compose.material3.lightColorScheme(
    primary = PrimaryGreen,
    secondary = SecondaryGreen,
    tertiary = AccentOrange,
    // Add light scheme variants if needed, but PRD/Mockups suggest a dark/vibrant theme
)
