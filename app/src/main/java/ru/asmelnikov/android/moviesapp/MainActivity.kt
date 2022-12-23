package ru.asmelnikov.android.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import ru.asmelnikov.android.moviesapp.navigation.SetupNavHost
import ru.asmelnikov.android.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                val navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}
