package com.gdg.composestudy23_5week.helper

import com.gdg.composestudy23_5week.model.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ThemeManager {
    private val _themeMode = MutableStateFlow(ThemeMode.LIGHT)
    val themeMode = _themeMode.asStateFlow()

    fun setThemeMode(themeMode: ThemeMode) {
        _themeMode.value = themeMode
    }

    companion object {
        fun create(): ThemeManager {
            return ThemeManager()
        }
    }
}

