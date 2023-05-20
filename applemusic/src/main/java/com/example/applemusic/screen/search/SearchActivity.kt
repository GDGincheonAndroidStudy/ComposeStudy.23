package com.example.applemusic.screen.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applemusic.ui.theme.GdgStudyTheme
import com.example.applemusic.widget.SearchBar

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GdgStudyTheme {
                Screen()
            }

        }
    }
}

@Composable
fun Screen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SearchBar()

    }
}