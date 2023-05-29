package com.example.applemusic.screen.setting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
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
                    topBar = { SettingTopAppBar() { finish() } }
                ) {
                    SettingScreen(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun SettingTopAppBar(finish: () -> Unit) {
    TopAppBar(title = { Text(text = "설정") },
        navigationIcon = {
            IconButton(onClick = { finish() }) {
                Icon(
                    modifier = Modifier,
                    tint = MaterialTheme.colors.secondary,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "뒤로가기"
                )
            }
        })
}