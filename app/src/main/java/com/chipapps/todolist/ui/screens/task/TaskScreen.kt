package com.chipapps.todolist.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = { action ->
                if (action == Action.NO_ACTION || action == Action.DELETE){
                    navigateToListScreen(action)
                }else{
                    if (sharedViewModel.validateFields()){
                        navigateToListScreen(action)
                    }else{
                        displayToast(context = context)
                    }
                }

            }, selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.updateTitle(it)
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

private fun displayToast(context: Context){
    Toast.makeText(context, "Field(s) must not be empty", Toast.LENGTH_SHORT).show()
}