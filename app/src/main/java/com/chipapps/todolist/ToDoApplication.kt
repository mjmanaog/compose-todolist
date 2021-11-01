package com.chipapps.todolist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //Will trigger hilt code generation including the base class of the app
class ToDoApplication: Application() {

}