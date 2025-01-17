package com.soujunior.petjournal.ui.screens_app.screen_home.homeScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.soujunior.petjournal.ui.screens_app.screen_home.homeScreen.components.Screen
import org.koin.androidx.compose.getViewModel

@ExperimentalPagerApi
@Composable
fun HomeScreen(navController: NavController) {
    Screen(navController, getViewModel())
}
