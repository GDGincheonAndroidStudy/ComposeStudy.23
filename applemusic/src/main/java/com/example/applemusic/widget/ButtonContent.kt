package com.example.applemusic

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonContent() {
    Column() {
        Text(text = stringResource(id = R.string.music_text), style = MaterialTheme.typography.h6)
        Text(text = stringResource(id = R.string.start_text), style = MaterialTheme.typography.subtitle1)
    }
}




