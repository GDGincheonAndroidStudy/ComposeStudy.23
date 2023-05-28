package com.example.applemusic.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingDialog() {
    Card(
        modifier = Modifier,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "설정")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "계정")
            }
        }
    }
}