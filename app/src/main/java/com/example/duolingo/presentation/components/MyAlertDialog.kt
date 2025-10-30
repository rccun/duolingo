package com.example.duolingo.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyAlertDialog(
    title: String,
    text: String,
    show: Boolean,
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(title) },
            text = { Text(text) },
            confirmButton = { confirmButton() }
        )
    }
}