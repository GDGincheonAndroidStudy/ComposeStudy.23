package com.gdg.composestudy23_5week.navigation

import android.provider.Settings.Global.getString
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gdg.composestudy23_5week.R
import com.gdg.composestudy23_5week.screen.locker.lockerNavigationRoute
import com.gdg.composestudy23_5week.screen.nowListeningNavigationRoute
import com.gdg.composestudy23_5week.screen.radio.radioNavigationRoute
import com.gdg.composestudy23_5week.screen.search.searchNavigationRoute
import com.gdg.composestudy23_5week.screen.see.seeListeningNavigationRoute

enum class BottomNavItem(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    NOWLISTENING(
        nowListeningNavigationRoute,
        R.drawable.baseline_play_circle_24,
        R.string.now_listening
    ),
    SEE(
        seeListeningNavigationRoute,
        R.drawable.baseline_grid_view_24,
        R.string.see
    ),
    RADIO(
        radioNavigationRoute,
        R.drawable.baseline_podcasts_24,
        R.string.radio
    ),
    LOCKER(
        lockerNavigationRoute,
        R.drawable.baseline_library_music_24,
        R.string.locker
    ),
    SEARCH(
        searchNavigationRoute,
        R.drawable.baseline_search_24,
        R.string.search
        )

}