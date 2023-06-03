package com.gdg.composestudy23_5week.data

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.gdg.composestudy23_5week.ui.theme.DarkColorPalette
import com.gdg.composestudy23_5week.ui.theme.LightColorPalette
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

object ThemeManager {
    private val _themeMode = MutableStateFlow(ThemeMode.LIGHT)
    val themeMode = _themeMode.asStateFlow()

    @Composable
    fun collectColors(): Colors {
        val themeMode by themeMode.collectAsState()

        return when (themeMode) {
            ThemeMode.LIGHT -> LightColorPalette
            ThemeMode.DARK -> DarkColorPalette
            ThemeMode.AUTO -> if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette
        }
    }

    @Composable
    fun collectIsDarkColorPalette() = collectColors() == DarkColorPalette

    fun setThemeMode(themeMode: ThemeMode) {
        _themeMode.value = themeMode
    }
}

enum class ThemeMode(val text: String) {
    LIGHT("Light"),
    DARK("Dark"),
    AUTO("System Default")
}