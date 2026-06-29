package com.example.trail.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object OtpVerification : Screen("otp_verification/{phoneNumber}") {
        fun createRoute(phoneNumber: String) = "otp_verification/$phoneNumber"
    }
    object LocationSelection : Screen("location_selection")
    object InterestSelection : Screen("interest_selection")
    object Home : Screen("home")
    object RunDetails : Screen("run_details/{runId}") {
        fun createRoute(runId: String) = "run_details/$runId"
    }
    object CreateRun : Screen("create_run")
    object Groups : Screen("groups")
    object GroupDetails : Screen("group_details/{groupId}") {
        fun createRoute(groupId: String) = "group_details/$groupId"
    }
    object Profile : Screen("profile")
    object Activity : Screen("activity")
    object Notifications : Screen("notifications")
}
