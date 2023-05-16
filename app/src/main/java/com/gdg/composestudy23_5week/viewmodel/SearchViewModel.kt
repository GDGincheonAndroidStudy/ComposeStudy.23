package com.gdg.composestudy23_5week.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdg.composestudy23_5week.data.Load
import com.gdg.composestudy23_5week.data.Music
import com.gdg.composestudy23_5week.repository.MusicChartModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchViewModel() : ViewModel() {
    val searchedList = MutableStateFlow<List<Music>>(emptyList())
    private val musicChartModule = MusicChartModule()

    fun searchList(content: String) {
        viewModelScope.launch {
            musicChartModule.getMusicList().runCatching {
                if (this is Load.Success<*>) {
                    searchedList.value = this.data as List<Music>
                }
            }
        }
    }
    fun setListEmpty() {
        searchedList.value = emptyList()
    }
}
