package com.example.trail.presentation.screens.otp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trail.presentation.components.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpVerificationScreen(
    phoneNumber: String,
    onVerify: () -> Unit,
    onBack: () -> Unit,
    viewModel: OtpViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    if (state.isVerificationSuccessful) {
        onVerify()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
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
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Verify Phone",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "Enter the 6-digit code sent to +91 $phoneNumber",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                modifier = Modifier.align(Alignment.Start).padding(top = 8.dp, bottom = 12.dp)
            )
            
            Text(
                text = "Test Code: 123456",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.Start).padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = state.otp,
                onValueChange = viewModel::onOtpChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("000000", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    letterSpacing = 8.sp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Verify & Continue",
                onClick = viewModel::onVerifyClick,
                enabled = state.otp.length == 6 && !state.isLoading
            )

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = { /* Handle Resend OTP */ }) {
                Text("Didn't receive code? Resend OTP")
            }
        }
    }
}
