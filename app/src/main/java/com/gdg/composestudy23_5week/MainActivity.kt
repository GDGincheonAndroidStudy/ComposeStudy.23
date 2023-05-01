package com.gdg.composestudy23_5week // ktlint-disable package-name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gdg.composestudy23_5week.ui.theme.ComposeStudy235weekTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigation(navController = navController)
    }) {
        Box(modifier = Modifier.padding(it)) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Radio.route) {
        composable(BottomNavItem.ListenNow.route) {
        }
        composable(BottomNavItem.Browse.route) {
        }
        composable(BottomNavItem.Radio.route) {
            RadioScreen()
        }
        composable(BottomNavItem.Library.route) {
        }
        composable(BottomNavItem.Search.route) {
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.ListenNow,
        BottomNavItem.Browse,
        BottomNavItem.Radio,
        BottomNavItem.Library,
        BottomNavItem.Search
    )
    androidx.compose.material.BottomNavigation(backgroundColor = Color.White, contentColor = Color.Red) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title, modifier = Modifier.size(25.dp))
                },
                label = { Text(text = item.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black.copy(alpha = 0.5f),
                selected = currentRoute == item.route,
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudy235weekTheme {
        MainScreen()
    }
}
