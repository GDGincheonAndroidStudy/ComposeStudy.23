package com.example.applemusic.data

import androidx.compose.ui.graphics.painter.Painter

data class RadioCardData(
    val title: String,
    val subTitle: String,
    val time: String,
    val imageTitle: String,
    val imageDescription: String,
    val bottomSheetImage: Painter,
    val moveScreen: () -> Unit
)
