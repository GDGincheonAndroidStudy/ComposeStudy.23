package com.gdg.composestudy23_5week.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cast
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.gdg.composestudy23_5week.model.NavigationItem

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val navItems = listOf(
        NavigationItem.ListenNow,
        NavigationItem.Browse,
        NavigationItem.Radio,
        NavigationItem.Library,
        NavigationItem.Search
    )

    Scaffold(
        bottomBar = {
            if (navBackStackEntry?.destination?.route in (navItems.map(NavigationItem::route)) + "TEST") {
                NavigationBar {
                    navItems.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    modifier = Modifier.size(25.dp)
                                )
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
        }
    ) { paddingValues ->
        NavHost(
            navController,
            MainDestinations.MAIN_ROUTE,
            Modifier.padding(paddingValues)
        ) {
            navigation(
                startDestination = NavigationItem.Radio.route,
                route = MainDestinations.MAIN_ROUTE
            ) {
                composable(NavigationItem.ListenNow.route) {
                    ListenNowScreen()
                }
                composable(NavigationItem.Browse.route) {
                    BrowseScreen()
                }
                composable(NavigationItem.Radio.route) {
                    RadioScreen(navigateToSettings = { navController.navigate(MainDestinations.SETTINGS_ROUTE) })
                }
                composable(NavigationItem.Library.route) {
                    LibraryScreen()
                }
                composable(NavigationItem.Search.route) {
                    SearchScreen(
                        navigateToSearchDetail = { navController.navigate("TEST") },
                        navigateToSettings = { navController.navigate(MainDestinations.SETTINGS_ROUTE) }
                    )
                }
                composable("TEST") {
                    SearchDetailScreen(onNavigateUp = navController::navigateUp)
                }
            }
            composable(MainDestinations.SETTINGS_ROUTE) {
                SettingsScreen(navigateUp = navController::navigateUp)
            }
        }
    }
}

@Composable
fun AppleMusicCloneAppBar(title: String, navigateToSettings: () -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    SmallTopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Cast,
                    contentDescription = "캐스트"
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Box {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "더보기"
                    )
                    DropdownMenu(
                        modifier = Modifier.wrapContentSize(),
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false }
                    ) {
                        DropdownMenuItem(text = { Text("설정") }, onClick = navigateToSettings)
                        DropdownMenuItem(text = { Text("계정") }, onClick = {})
                    }
                }
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

object MainDestinations {
    const val MAIN_ROUTE = "Main"
    const val SETTINGS_ROUTE = "Settings"
}