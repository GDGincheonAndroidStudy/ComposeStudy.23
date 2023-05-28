package com.example.applemusic.screen.setting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applemusic.ui.theme.GdgStudyTheme

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GdgStudyTheme {
                Scaffold(
                    topBar = { SettingTopAppBar() }
                ) {
                    SettingScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun SettingTopAppBar() {
    TopAppBar(title = { Text(text = "설정") },
        navigationIcon = {
            Icon(
                modifier = Modifier.padding(start = 8.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "뒤로가기"
            )
        })
}