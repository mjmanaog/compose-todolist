package com.chipapps.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chipapps.todolist.navigation.destinations.listComposable
import com.chipapps.todolist.navigation.destinations.taskComposable
import com.chipapps.todolist.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    val screen = remember(navHostController) {
        Screens(navController = navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen =  screen.task)
        taskComposable(navigateToListScreen = screen.list)
    }
}