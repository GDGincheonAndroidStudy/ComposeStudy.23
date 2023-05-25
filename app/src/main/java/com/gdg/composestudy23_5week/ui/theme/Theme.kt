package com.gdg.composestudy23_5week.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.gdg.composestudy23_5week.data.ThemeManager
import com.gdg.composestudy23_5week.data.ThemeMode
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = KawaiRed,
    primaryVariant = Purple700,
    secondary = Teal200,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = KawaiRed,
    primaryVariant = Purple700,
    secondary = Teal200,
    onBackground = Color.Black
)

@Composable
fun ComposeStudy235weekTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val themeMode by ThemeManager.themeMode.collectAsState()
    val colors = when (themeMode) {
        ThemeMode.LIGHT -> LightColorPalette
        ThemeMode.DARK -> DarkColorPalette
        ThemeMode.AUTO -> if (darkTheme) DarkColorPalette else LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
    
    LaunchedEffect(colors) {
        systemUiController.setSystemBarsColor(
            color = colors.background
        )
    }
}