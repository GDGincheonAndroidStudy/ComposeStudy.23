package com.gdg.composestudy23_5week

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme

@ExperimentalMaterial3Api
@Composable
fun AppleMusicCloneApp() {
    ComposeStudy235weekTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}