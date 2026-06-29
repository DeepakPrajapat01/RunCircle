package com.example.trail.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.Text
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            com.example.trail.presentation.screens.splash.SplashScreen(
                onNavigateToOnboarding = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(Screen.Login.route) {
            com.example.trail.presentation.screens.login.LoginScreen(
                onContinue = { phoneNumber ->
                    navController.navigate(Screen.OtpVerification.createRoute(phoneNumber))
                }
            )
        }
        composable(
            route = Screen.OtpVerification.route,
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            com.example.trail.presentation.screens.otp.OtpVerificationScreen(
                phoneNumber = phoneNumber,
                onVerify = {
                    navController.navigate(Screen.LocationSelection.route)
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.LocationSelection.route) {
            com.example.trail.presentation.screens.location.LocationSelectionScreen(
                onCitySelected = { city ->
                    navController.navigate(Screen.InterestSelection.route)
                }
            )
        }
        composable(Screen.InterestSelection.route) {
            com.example.trail.presentation.screens.interest.InterestSelectionScreen(
                onComplete = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            com.example.trail.presentation.screens.home.HomeScreen(
                onRunClick = { runId ->
                    navController.navigate(Screen.RunDetails.createRoute(runId))
                }
            )
        }
        composable(
            route = Screen.RunDetails.route,
            arguments = listOf(navArgument("runId") { type = NavType.StringType })
        ) { backStackEntry ->
            val runId = backStackEntry.arguments?.getString("runId") ?: ""
            com.example.trail.presentation.screens.run_details.RunDetailsScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.CreateRun.route) {
            com.example.trail.presentation.screens.create_run.CreateRunScreen(
                onBack = { navController.popBackStack() },
                onSuccess = { navController.popBackStack() }
            )
        }
        composable(Screen.Groups.route) {
            com.example.trail.presentation.screens.groups.GroupsScreen(
                onGroupClick = { groupId ->
                    navController.navigate(Screen.GroupDetails.createRoute(groupId))
                }
            )
        }
        composable(
            route = Screen.GroupDetails.route,
            arguments = listOf(navArgument("groupId") { type = NavType.StringType })
        ) { 
            com.example.trail.presentation.screens.group_details.GroupDetailsScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Profile.route) {
            com.example.trail.presentation.screens.profile.ProfileScreen()
        }
        composable(Screen.Activity.route) {
            com.example.trail.presentation.screens.activity.ActivityScreen(
                onRunClick = { runId ->
                    navController.navigate(Screen.RunDetails.createRoute(runId))
                }
            )
        }
        composable(Screen.Notifications.route) {
            com.example.trail.presentation.screens.notifications.NotificationsScreen()
        }
    }
}
