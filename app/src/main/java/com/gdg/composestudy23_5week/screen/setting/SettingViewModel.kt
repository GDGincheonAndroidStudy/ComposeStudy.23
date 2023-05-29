package com.gdg.composestudy23_5week.screen.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingViewModel(newTheme: String) : ViewModel() {

    private val _theme = MutableStateFlow("Auto")
    val theme = _theme.asStateFlow()

    init {
        onThemeChange(newTheme)
    }

    fun onThemeChange(newTheme: String) {
        viewModelScope.launch {
            when(newTheme) {
                "Auto" -> _theme.value = "Light"
                "Light" -> _theme.value = "Dark"
                "Dark" -> _theme.value = "Auto"
            }
        }
    }
}