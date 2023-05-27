package com.gdg.composestudy23_5week.ui

import androidx.lifecycle.ViewModel
import com.gdg.composestudy23_5week.helper.ThemeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val themeManager: ThemeManager) : ViewModel() {
    val themeMode get() = themeManager.themeMode
}