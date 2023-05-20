package com.gdg.composestudy23_5week.screen.search

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.gdg.composestudy23_5week.screen.search_detail.SearchDetailScreen
import com.gdg.composestudy23_5week.screen.search_detail.searchDetailhNavigationRoute
import com.google.accompanist.navigation.animation.composable

const val searchNavigationRoute = "search_route"

fun NavController.navigateSearch(
    navOptions: NavOptions? = null
) {
    this.navigate(searchNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.searchScreen(
    navigateToSearchDetail: () -> Unit
) {
    composable(searchNavigationRoute,
        content = {
            SearchScreen(
                navigateToSearchDetail = navigateToSearchDetail
            )
        },
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    )
}