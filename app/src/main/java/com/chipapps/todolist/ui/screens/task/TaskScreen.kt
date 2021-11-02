package com.chipapps.todolist.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.chipapps.todolist.data.models.Priority
import com.chipapps.todolist.data.models.ToDoTask
import com.chipapps.todolist.ui.viewmodels.SharedViewModel
import com.chipapps.todolist.util.Action

@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen, selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.title.value = it
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}