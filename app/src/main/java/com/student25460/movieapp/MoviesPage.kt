package com.student25460.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesPage(
    movies : List<Movie>,
    movieId : Int,
    navController : NavController,
    modifier: Modifier
) {
    val movie = movies.first { it.id == movieId }
    var seatsSelected by remember { mutableStateOf(movie.seatsSelected) }
    var seatsRemaining by remember { mutableStateOf(movie.seatsRemaining) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Arrow Back")
                    }

                },
                title = { Text(text = "Movie On", fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )


            )
        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(color = Color.Black),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(painter = painterResource(id= movie.image),
                    contentDescription = movie.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp))

                Text(text = movie.name, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(text = movie.certification, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(text = movie.starring, fontSize = 20.sp, color = Color.White)
                Text(text = movie.runningTimeMins, fontSize = 20.sp, color = Color.White)
                
                Spacer(modifier = Modifier.height(20.dp))

                Row (modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Select Seats",fontSize = 20.sp, color = Color.White)
                    IconButton(onClick = {
                        if (seatsSelected > 0) {
                            seatsSelected--
                            seatsRemaining++
                        }
                    }) {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrease seats", tint = Color.White)
                    }
                    Text("$seatsSelected", fontSize = 24.sp, color = Color.White)
                    IconButton(onClick = {
                        if (seatsRemaining > 0) {
                            seatsSelected++
                            seatsRemaining--
                        }
                    }) {
                        Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increase seats", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "$seatsRemaining seats remaining", fontSize = 20.sp, color = Color.White)
                }

            }
        }
    )
}
                












