package com.gdg.composestudy23_5week.presentation.radio

import androidx.annotation.DrawableRes

data class Album(
    val section: String,
    val description: String,
    @DrawableRes val imageId: Int
)