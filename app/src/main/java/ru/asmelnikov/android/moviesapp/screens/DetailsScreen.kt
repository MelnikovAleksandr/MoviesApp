@file:OptIn(ExperimentalCoilApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package ru.asmelnikov.android.moviesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import ru.asmelnikov.android.moviesapp.MainViewModel
import ru.asmelnikov.android.moviesapp.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {

    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull { it.id == itemId.toInt() }

    val rating = currentItem?.rating?.average ?: 0.0

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(currentItem?.image?.medium),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp)
            )
            Text(
                text = currentItem?.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Rating: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                when (rating) {
                    in 7.0..10.0 -> {
                        Text(
                            text = currentItem?.rating?.average.toString(),
                            fontSize = 18.sp,
                            color = Color.Green
                        )
                    }
                    in 5.0..7.0 -> {
                        Text(
                            text = currentItem?.rating?.average.toString(),
                            fontSize = 18.sp,
                            color = Color.Yellow
                        )
                    }
                    else -> {
                        Text(
                            text = currentItem?.rating?.average.toString(),
                            fontSize = 18.sp,
                            color = Color.Red
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Genre: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                currentItem?.genres?.take(2)?.forEach {
                    Text(
                        text = " [$it] ",
                        fontSize = 18.sp
                    )
                }
            }
            HtmlText(
                html = currentItem?.summary ?: "",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}