package com.gdg.composestudy23_5week

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
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
                ListenNowScreen()
            }
            composable(NavigationItem.Browse.route) {
                BrowseScreen()
            }
            composable(NavigationItem.Radio.route) {
                RadioScreen()
            }
            composable(NavigationItem.Library.route) {
                LibraryScreen()
            }
            composable(NavigationItem.Search.route) {
                SearchScreen(navigateToSearchDetail = { navController.navigate("TEST") })
            }
            composable("TEST") {
                SearchDetailScreen(onNavigateUp = navController::navigateUp)
            }
        }
    }
}

@Composable
fun AppleMusicCloneAppBar(title: String) {
    SmallTopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Cast,
                    contentDescription = "캐스트"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "더보기"
                )
            }
        }
    )
}

@Composable
fun TitleHeader(title: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}