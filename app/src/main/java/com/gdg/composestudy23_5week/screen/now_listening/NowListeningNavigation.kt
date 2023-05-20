package com.gdg.composestudy23_5week.screen

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.gdg.composestudy23_5week.screen.now_listening.NowListeningScreen

const val nowListeningNavigationRoute ="now_listening_route_route"

fun NavController.navigateNowListening(
    navOptions: NavOptions? = null
) {
    this.navigate(nowListeningNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.nowListeningScreen() {
    composable(
        nowListeningNavigationRoute,
        content = {
            NowListeningScreen()
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