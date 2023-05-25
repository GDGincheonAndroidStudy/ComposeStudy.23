package com.gdg.composestudy23_5week.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ThemeManager {
    private val _themeMode = MutableStateFlow(ThemeMode.LIGHT)
    val themeMode = _themeMode.asStateFlow()

    fun setThemeMode(themeMode: ThemeMode) {
        _themeMode.value = themeMode
    }
}

enum class ThemeMode(val text: String) {
    LIGHT("Light"),
    DARK("Dark"),
    AUTO("System Default")
}