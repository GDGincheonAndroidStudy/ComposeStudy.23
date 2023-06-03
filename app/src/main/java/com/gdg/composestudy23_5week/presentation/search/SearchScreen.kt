package com.gdg.composestudy23_5week.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.debounce

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var (query, setQuery) = remember {
            mutableStateOf("")
        }
        val data = remember {
            listOf("가나", "가나다", "가나다라", "카카", "카타", "카타라", "카타나", "사사", "사지", "사지절단")
        }
        val result = remember(query, data) {
            if (query.isNotEmpty())
                data.filter { it.contains(query) }
            else
                emptyList()
        }

        Text(text = "Search", style = MaterialTheme.typography.h6)

        BasicTextField(value = query, onValueChange = setQuery) { innerTextField ->
            if (query.isEmpty()) {
                Text(
                    text = "Artists, Songs, Lyrics and more",
                    style = MaterialTheme.typography.body1
                )
            } else {
                innerTextField()
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(result) {
                Text(text = it)
            }
        }
    }
}