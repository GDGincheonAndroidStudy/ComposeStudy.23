package com.gdg.composestudy23_5week.ui

import androidx.lifecycle.ViewModel
import com.gdg.composestudy23_5week.helper.ThemeManager
import com.gdg.composestudy23_5week.model.ThemeMode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val themeManager: ThemeManager) : ViewModel() {
    val themeMode get() = themeManager.themeMode

    fun setTheme(themeMode: ThemeMode) {
        themeManager.setThemeMode(themeMode)
    }
}