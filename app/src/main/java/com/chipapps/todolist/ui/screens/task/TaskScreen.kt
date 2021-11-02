package com.chipapps.todolist.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.chipapps.todolist.data.models.Priority
import com.chipapps.todolist.data.models.ToDoTask
import com.chipapps.todolist.util.Action

@Composable
fun TaskScreen(selectedTask: ToDoTask?, navigateToListScreen: (Action) -> Unit) {
    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen, selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = "",
                onTitleChange = {},
                description = "",
                onDescriptionChange = {},
                priority = Priority.HIGH,
                onPrioritySelected = {}
            )
        }
    )
}