package com.example.applemusic.screen.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applemusic.data.SearchState
import com.example.applemusic.network.MusicRepository
import com.example.applemusic.ui.theme.GdgStudyTheme
import com.example.applemusic.widget.SearchBar
import kotlinx.coroutines.delay

class SearchActivity : ComponentActivity() {
    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }
    private val viewModelFactory: SearchViewModelFactory by lazy {
        SearchViewModelFactory(MusicRepository())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(Unit) {
                viewModel.bringMusicList()
            }

            GdgStudyTheme {
                Screen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Screen(viewModel: SearchViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(viewModel = viewModel)
        when (viewModel.state.value) {
            is SearchState.Empty -> {
                SearchEmptyScreen(viewModel = viewModel)
            }
            is SearchState.Searching -> {
                SearchingScreen(viewModel = viewModel)
            }
            is SearchState.Fill -> {

            }
        }

    }
}

@Composable
fun SearchEmptyScreen(viewModel: SearchViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Recent Searched", fontWeight = FontWeight.Bold)
            Text(
                text = "Clear",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.clickable { viewModel.clearList() })
        }
        Divider()
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            repeat(viewModel.list.size) {
                Text(text = viewModel.list[it])
            }
        }


    }
}