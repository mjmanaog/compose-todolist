package com.chipapps.todolist.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.chipapps.todolist.ui.screens.splash.SplashScreen
import com.chipapps.todolist.util.Constants

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(targetOffsetY = { -it }, animationSpec = tween(300))
        }
//        ,
//        popEnterTransition =
//   etc...
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}