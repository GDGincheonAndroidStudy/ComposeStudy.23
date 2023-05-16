package com.example.applemusic.widget

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Title(title: String) {
    Text(text = title, style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.Bold))
}