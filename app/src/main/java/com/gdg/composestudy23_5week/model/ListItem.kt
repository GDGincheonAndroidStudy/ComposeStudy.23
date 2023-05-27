package com.gdg.composestudy23_5week.model

sealed class ListItem {
    data class MusicStation(
        val title: String,
        val description: String,
        val image: Int
    ) : ListItem()

    data class RadioMusic(
        val title: String,
        val description: String,
        val time: String,
        val musicStation: MusicStation
    )

    data class StationsByGenre(val stations: List<MusicStation>) : ListItem()

    data class More(val genre: String) : ListItem()
}