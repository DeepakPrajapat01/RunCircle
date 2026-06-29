package com.example.trail.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(Screen.Home.route, "Home", Icons.Default.Home)
    object Groups : BottomNavItem(Screen.Groups.route, "Groups", Icons.Default.Group)
    object Create : BottomNavItem(Screen.CreateRun.route, "Create", Icons.Default.AddCircle)
    object Activity : BottomNavItem(Screen.Activity.route, "Activity", Icons.Default.History)
    object Profile : BottomNavItem(Screen.Profile.route, "Profile", Icons.Default.Person)
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Groups,
    BottomNavItem.Create,
    BottomNavItem.Activity,
    BottomNavItem.Profile
)
