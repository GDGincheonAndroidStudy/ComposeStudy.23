package com.gdg.composestudy23_5week.screen.search_detail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable

const val searchDetailhNavigationRoute = "search_detail_route"

fun NavController.navigateSearchDetail(
    navOptions: NavOptions? = null
) {
    this.navigate(searchDetailhNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.searchDetailScreen(
    navigateToBack: () -> Unit
) {
    composable(searchDetailhNavigationRoute,
        content = {
            SearchDetailScreen(navigateToBack)
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