package com.example.applemusic.screen.search

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.applemusic.data.MusicChart
import com.example.applemusic.widget.AutoCompleteCard
import com.example.applemusic.widget.MusicCard

@Composable
fun SearchingScreen(viewModel: SearchViewModel) {
    val searchList = remember {
        mutableStateOf(emptyList<MusicChart>())
    }
    val autoCompleteList = remember {
        mutableStateListOf<String>()
    }

    LaunchedEffect(viewModel.text.value) {
        searchList.value = viewModel.musicList.value.filter {
            it.title.contains(viewModel.text.value, ignoreCase = true)
        }
        searchList.value.forEach {
            autoCompleteList.add(it.title)
        }
        Log.d("daeYoung", "list: ${searchList}")
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(modifier = Modifier.padding(16.dp), text = "APPLE MUSIC", color = MaterialTheme.colors.secondary, fontWeight = FontWeight.Bold)
        Divider(thickness = 1.dp, color = MaterialTheme.colors.secondary, )

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            for (i in 0 until searchList.value.size) {
                item { AutoCompleteCard(inputText = viewModel.text.value, autoCompleteText = searchList.value[i].title) }
                if (i == 3) break
            }
            items(searchList.value.size) {
                MusicCard(musicChart = searchList.value[it])
            }
        }
        
    }

}

