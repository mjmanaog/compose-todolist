package com.chipapps.todolist.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.chipapps.todolist.navigation.destinations.listComposable
import com.chipapps.todolist.navigation.destinations.splashComposable
import com.chipapps.todolist.navigation.destinations.taskComposable
import com.chipapps.todolist.ui.viewmodels.SharedViewModel
import com.chipapps.todolist.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navHostController) {
        Screens(navController = navHostController)
    }

    AnimatedNavHost(
        navController = navHostController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(navigateToListScreen = screen.splash)
        listComposable(navigateToTaskScreen = screen.list, sharedViewModel = sharedViewModel)
        taskComposable(navigateToListScreen = screen.task, sharedViewModel = sharedViewModel)
    }
}