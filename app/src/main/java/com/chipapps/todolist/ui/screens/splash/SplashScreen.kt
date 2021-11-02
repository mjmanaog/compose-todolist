package com.chipapps.todolist.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.chipapps.todolist.R
import com.chipapps.todolist.ui.theme.LOGO_HEIGHT
import com.chipapps.todolist.ui.theme.splashBackground
import com.chipapps.todolist.util.Constants.SPLASH_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToListScreen: () -> Unit) {

    LaunchedEffect(key1 = true){
        delay(SPLASH_DELAY)
        navigateToListScreen()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(LOGO_HEIGHT),
            painter = painterResource(id = getLogo()),
            contentDescription = stringResource(id = R.string.todo_logo)
        )
    }
}

@Composable
fun getLogo(): Int {
    return if (isSystemInDarkTheme()) {
        R.drawable.ic_logo_dark
    } else {
        R.drawable.ic_logo_light
    }
}