package com.gdg.composestudy23_5week.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gdg.composestudy23_5week.helper.ThemeManager
import com.gdg.composestudy23_5week.model.ThemeMode
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme

@ExperimentalMaterial3Api
@Composable
fun AppleMusicCloneApp() {
    val viewModel: MainViewModel = hiltViewModel()
    val themeMode by viewModel.themeMode.collectAsState()

    ComposeStudy235weekTheme(darkTheme = themeMode == ThemeMode.DARK) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}