package com.gdg.composestudy23_5week

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.HorizontalSplit
import androidx.compose.material.icons.rounded.OnlinePrediction
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gdg.composestudy23_5week.ui.radio.RadioScheduleScreen
import com.gdg.composestudy23_5week.ui.radio.RadioScreen
import com.gdg.composestudy23_5week.ui.search.SearchScreen
import com.gdg.composestudy23_5week.ui.theme.DeepGray
import com.gdg.composestudy23_5week.ui.theme.PinkRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenView()
        }
    }
}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        Box(Modifier.padding(it)){
            NavigationGraph(navController = navController)
        }
    }
}

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val screenRoute: String
) {
    object Listen : BottomNavItem("Listen Now", Icons.Rounded.PlayCircle, "LISTEN")
    object Browse : BottomNavItem("Browse", Icons.Rounded.Dashboard, "BROWSE")
    object Radio : BottomNavItem("Radio", Icons.Rounded.OnlinePrediction, "RADIO")
    object Library : BottomNavItem("Library", Icons.Rounded.HorizontalSplit, "LIBRARY")
    object Search : BottomNavItem("Search", Icons.Rounded.Search, "SEARCH")
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Listen,
        BottomNavItem.Browse,
        BottomNavItem.Radio,
        BottomNavItem.Library,
        BottomNavItem.Search
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = PinkRed
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon( imageVector = item.icon, contentDescription = item.title, modifier = Modifier.size(30.dp))},
                label = { Text( text = item.title, maxLines = 1, overflow = TextOverflow.Ellipsis )},
                selectedContentColor = PinkRed,
                unselectedContentColor = DeepGray,
                selected = currentRoute == item.screenRoute,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.screenRoute) {
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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Radio.screenRoute) {
        composable(BottomNavItem.Listen.screenRoute) {}
        composable(BottomNavItem.Browse.screenRoute) {}
        composable(BottomNavItem.Radio.screenRoute) {
            RadioScreen()
        }
        composable(BottomNavItem.Library.screenRoute) {}
        composable(BottomNavItem.Search.screenRoute) {
            SearchScreen()
        }
    }
}