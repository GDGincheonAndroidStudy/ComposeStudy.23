package com.example.applemusic.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.applemusic.network.MusicRepository

class SearchViewModelFactory(private val repository: MusicRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MusicRepository::class.java).newInstance(repository)
    }
}