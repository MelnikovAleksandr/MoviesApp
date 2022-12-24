package ru.asmelnikov.android.moviesapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ru.asmelnikov.android.moviesapp.MainViewModel
import ru.asmelnikov.android.moviesapp.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value

    allMovies.forEach {
        Log.d("checkData", "${it.id} : ${it.name}")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(250)) { item ->
                MovieItem(item = item)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = item.id.toString())
        Text(text = item.name)
    }
}