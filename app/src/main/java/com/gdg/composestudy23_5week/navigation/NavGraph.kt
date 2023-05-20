package com.gdg.composestudy23_5week.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gdg.composestudy23_5week.component.CustomBottomAppBar
import com.gdg.composestudy23_5week.component.CustomScaffold
import com.gdg.composestudy23_5week.screen.locker.lockerScreen
import com.gdg.composestudy23_5week.screen.nowListeningScreen
import com.gdg.composestudy23_5week.screen.radio.radioScreen
import com.gdg.composestudy23_5week.screen.search.searchNavigationRoute
import com.gdg.composestudy23_5week.screen.search.searchScreen
import com.gdg.composestudy23_5week.screen.search_detail.navigateSearchDetail
import com.gdg.composestudy23_5week.screen.search_detail.searchDetailScreen
import com.gdg.composestudy23_5week.screen.see.seeListeningNavigationRoute
import com.gdg.composestudy23_5week.screen.see.seeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    CustomScaffold(
        bottomBar = {
            BottomNavItem.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    CustomBottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = seeListeningNavigationRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            nowListeningScreen()
            seeScreen()
            radioScreen()
            lockerScreen()
            searchScreen {navController.navigateSearchDetail()}

            searchDetailScreen { navController.popBackStack() }
        }
    }
}

