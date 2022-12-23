package ru.asmelnikov.android.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.asmelnikov.android.moviesapp.screens.MainScreen
import ru.asmelnikov.android.moviesapp.screens.SplashScreen
import ru.asmelnikov.android.moviesapp.utils.Constants.Screens.DETAILS_SCREEN
import ru.asmelnikov.android.moviesapp.utils.Constants.Screens.MAIN_SCREEN
import ru.asmelnikov.android.moviesapp.utils.Constants.Screens.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object Splash : Screens(route = SPLASH_SCREEN)
    object Main : Screens(route = MAIN_SCREEN)
    object Details : Screens(route = DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Main.route) {
            MainScreen()
        }
        composable(route = Screens.Details.route) {

        }
    }
}