package com.chipapps.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chipapps.todolist.navigation.SetupNavigation
import com.chipapps.todolist.ui.theme.TodoListTheme
import com.chipapps.todolist.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                navController = rememberNavController()
                SetupNavigation(navHostController = navController, sharedViewModel = sharedViewModel)
            }
        }
    }
}
