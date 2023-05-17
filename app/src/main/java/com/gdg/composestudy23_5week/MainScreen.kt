package com.gdg.composestudy23_5week

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text(navBackStackEntry?.destination?.route ?: "") })
        },
        bottomBar = {
            NavigationBar {
                listOf(
                    NavigationItem.ListenNow,
                    NavigationItem.Browse,
                    NavigationItem.Radio,
                    NavigationItem.Library,
                    NavigationItem.Search
                ).forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.title, modifier = Modifier.size(25.dp))
                        },
                        label = { Text(text = item.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                        selected = navBackStackEntry?.destination?.route == item.route,
                        alwaysShowLabel = true,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            NavigationItem.Radio.route,
            Modifier.padding(paddingValues)
        ) {
            composable(NavigationItem.ListenNow.route) {
            }
            composable(NavigationItem.Browse.route) {
            }
            composable(NavigationItem.Radio.route) {
                RadioScreen()
            }
            composable(NavigationItem.Library.route) {
            }
            composable(NavigationItem.Search.route) {
                SearchScreen()
            }
        }
    }
}