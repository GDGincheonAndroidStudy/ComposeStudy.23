package com.gdg.composestudy23_5week

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchDetailViewModel @Inject constructor() : ViewModel() {
    var text by mutableStateOf("")
}