package com.gdg.composestudy23_5week.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    object ListenNow : NavigationItem("ListenNow", Icons.Rounded.PlayCircle, "LISTENNOW")
    object Browse : NavigationItem("Browse", Icons.Rounded.Widgets, "BROWSE")
    object Radio : NavigationItem("Radio", Icons.Rounded.Sensors, "RADIO")
    object Library : NavigationItem("Library", Icons.Rounded.LibraryMusic, "LIBRARY")
    object Search : NavigationItem("Search", Icons.Rounded.Search, "SEARCH")
}