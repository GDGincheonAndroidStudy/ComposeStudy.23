package com.example.applemusic

const val LISTEN = "nowListenScreen"
const val LOOK = "lookaroundScreen"
const val RADIO = "radioScreen"
const val STORE = "storeScreen"
const val SEARCH = "searchScreen"


sealed class BottomNavItem(
    val screenRoute: String,
    val Icon: Int,
    val Title: Int
) {
    object NowListenScreen: BottomNavItem(
        screenRoute = LISTEN,
        Icon = R.drawable.baseline_play_circle_24,
        Title = R.string.bottom_nav_title1,
    )

    object LookScreen: BottomNavItem(
        screenRoute = LOOK,
        Icon = R.drawable.baseline_apps_24,
        Title = R.string.bottom_nav_title2,
    )

    object RadioScreen: BottomNavItem(
        screenRoute = RADIO,
        Icon = R.drawable.baseline_radio_24,
        Title = R.string.bottom_nav_title3,
    )

    object StoreScreen: BottomNavItem(
        screenRoute = STORE,
        Icon = R.drawable.baseline_library_music_24,
        Title = R.string.bottom_nav_title4,
    )

    object SearchScreen: BottomNavItem(
        screenRoute = SEARCH,
        Icon = R.drawable.baseline_search_24,
        Title = R.string.bottom_nav_title5,
    )
}
