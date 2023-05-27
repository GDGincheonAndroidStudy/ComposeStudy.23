package com.example.applemusic.data

sealed class SearchState() {

    object Empty: SearchState()
    object Searching: SearchState()
    object Fill: SearchState()
}
