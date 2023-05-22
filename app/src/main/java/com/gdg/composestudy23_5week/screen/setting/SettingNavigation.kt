package com.gdg.composestudy23_5week.screen.setting

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable

const val settingNavigationRoute = "setting_route"

fun NavController.navigateSetting(
    navOptions: NavOptions? = null
) {
    this.navigate(settingNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingScreen(
    navigateToBack: () -> Unit
) {
    composable(settingNavigationRoute,
        content = {
            SettingScreen(navigateToBack)
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