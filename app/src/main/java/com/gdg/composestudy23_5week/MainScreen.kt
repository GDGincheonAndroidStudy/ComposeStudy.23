package com.gdg.composestudy23_5week

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(topBar = {
        LargeTopAppBar(title = { Text("라디오") })
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn {
                item {
                    Text("테스트")
                }
            }
        }
    }
}