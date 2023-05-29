package com.example.applemusic.screen.setting

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.applemusic.ui.theme.GdgStudyTheme

sealed class AppTheme{
    object Light: AppTheme()
    object Dark: AppTheme()
    object System: AppTheme()

}

class SettingActivity : ComponentActivity() {
    lateinit var appTheme: AppTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var appTheme: AppTheme by remember { mutableStateOf(AppTheme.System) }

            GdgStudyTheme(darkTheme = when (appTheme) {
                AppTheme.Light -> {
                    Log.d("daeYoung", "현재 테마 상태: Light")
                    false}
                AppTheme.Dark -> {
                    Log.d("daeYoung", "현재 테마 상태: Dark")
                    true}
                AppTheme.System -> {
                    Log.d("daeYoung", "현재 테마 상태: System")
                    isSystemInDarkTheme()}
            }) {
                Scaffold(
                    topBar = { SettingTopAppBar() { finish() } }
                ) {
                    SettingScreen(modifier = Modifier.padding(it)){ appTheme2:AppTheme -> appTheme = appTheme2
                    Log.d("daeYoung", "현재 테마 상태: ${appTheme}")}
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