package com.chipapps.todolist.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chipapps.todolist.ui.screens.task.TaskScreen
import com.chipapps.todolist.ui.viewmodels.SharedViewModel
import com.chipapps.todolist.util.Action
import com.chipapps.todolist.util.Constants
import com.chipapps.todolist.util.Constants.TASK_ARGUMENT_KEY

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = taskId){
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        LaunchedEffect(key1 = selectedTask){
            if(selectedTask != null || taskId == -1){
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask
        )
    }
}