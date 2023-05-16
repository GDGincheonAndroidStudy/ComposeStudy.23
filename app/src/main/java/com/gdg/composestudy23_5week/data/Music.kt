package com.gdg.composestudy23_5week.data

import kotlinx.serialization.Serializable
@Serializable
data class Music(val title: String, val artist: List<String>, val thumbnail: String)
