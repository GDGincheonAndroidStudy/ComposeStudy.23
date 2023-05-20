package com.gdg.composestudy23_5week.component

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.core.os.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.gdg.composestudy23_5week.navigation.BottomNavItem
import com.gdg.composestudy23_5week.screen.locker.navigateLocker
import com.gdg.composestudy23_5week.screen.navigateNowListening
import com.gdg.composestudy23_5week.screen.radio.navigateRadio
import com.gdg.composestudy23_5week.screen.search.navigateSearch
import com.gdg.composestudy23_5week.screen.see.navigateSee

@Composable
fun CustomBottomAppBar(
    navController: NavController,
    currentDestination: NavDestination?
) {
    BottomAppBar(
        backgroundColor = Color.White,
    ) {
        BottomNavItem.values().forEach { screen ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(screen)

            BottomNavigationItem(
                alwaysShowLabel = true,
                selectedContentColor = Color.Red,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.titleTextId),
                        color = Color.Gray,
                        style = MaterialTheme.typography.overline,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                },
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(screen, navController)
                }
            )
        }
    }
}

fun navigateToBottomNavDestination(
    bottomNavItem: BottomNavItem,
    navController: NavController
) {
    val bottomNavOptions = navOptions {
        trace("Navigation ${bottomNavItem.name}") {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    when (bottomNavItem) {
        BottomNavItem.NOWLISTENING -> navController.navigateNowListening(bottomNavOptions)
        BottomNavItem.SEE -> navController.navigateSee(bottomNavOptions)
        BottomNavItem.RADIO -> navController.navigateRadio(bottomNavOptions)
        BottomNavItem.LOCKER -> navController.navigateLocker(bottomNavOptions)
        BottomNavItem.SEARCH -> navController.navigateSearch(bottomNavOptions)
    }
}

private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNavItem) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

