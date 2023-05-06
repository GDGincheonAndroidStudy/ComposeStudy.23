package com.example.applemusic.widget

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.applemusic.BottomNavItem
import com.example.applemusic.RADIO

@Composable
fun BottomNavigation(navController: NavHostController) {
    val list = listOf<BottomNavItem>(
        BottomNavItem.NowListenScreen,
        BottomNavItem.LookScreen,
        BottomNavItem.RadioScreen,
        BottomNavItem.StoreScreen,
        BottomNavItem.SearchScreen
    )

    androidx.compose.material.BottomNavigation() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        list.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.Icon),
                        contentDescription = stringResource(id = item.Title)
                    )
                },
                label = { Text(text = stringResource(id = item.Title), fontSize = 9.sp) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.LightGray,
                selected = item.screenRoute == currentRoute,
                onClick = {
                    if (item.screenRoute == RADIO) {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}