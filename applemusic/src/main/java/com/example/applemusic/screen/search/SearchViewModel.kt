package com.example.applemusic.screen.search

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.applemusic.data.ApiState
import com.example.applemusic.data.MusicChart
import com.example.applemusic.data.SearchState
import com.example.applemusic.network.MusicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel(private val apiRepository: MusicRepository) : ViewModel() {
    private val _text = mutableStateOf("")
    val text: State<String> = _text

    private val _state = mutableStateOf<SearchState>(SearchState.Empty)
    val state: State<SearchState> = _state

    private val _list = mutableStateListOf<String>()
    val list: List<String> = _list

    private val _musicList = mutableStateOf(emptyList<MusicChart>())
    val musicList: State<List<MusicChart>> = _musicList

    suspend fun bringMusicList() {
        apiRepository.getRepository().collect { apiState ->
            when (apiState) {
                is ApiState.Success<*> -> {
                    _musicList.value = apiState.value as List<MusicChart>
                    Log.d("daeYoung", "성공: ${musicList}")
                }
                is ApiState.Error -> {
                    _musicList.value = emptyList()
                    Log.d("daeYoung", "실패: ${apiState.errMsg}")
                }
                else -> {}
            }
        }
    }

    fun setText(text: String) {
        _text.value = text
    }

    fun addList(title: String) {
        _list.add(title)
    }

    fun clearList() {
        _list.clear()
    }

    fun setState(state: SearchState) {
        _state.value = state
    }
}