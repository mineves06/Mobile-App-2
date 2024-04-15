package com.student25460.movieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaHomePage(
    movies : List<Movie>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }

                },
                title = { Text(text = "Dorset Cinema", fontSize = 20.sp) },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Share, contentDescription = "Share")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More")
                    }

                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,

                )


            )
        },
        content = {
            

            Column(Modifier.padding(1.dp).background(color = Color.White)) {

                LazyColumn(Modifier.padding(it))
                {
                    items(movies.size) { index ->
                        ColumnItem(
                            movie = movies[index],
                            modifier,
                            navController = navController

                        );
                        {


                        }
                    }


                }
            }
            

            
        }

    )

}

@Composable
fun ColumnItem(
    movie: Movie,
    modifier: Modifier,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .wrapContentSize()
            .clickable { navController.navigate(route = "MoviesPage/${movie.id}") },
        colors = CardDefaults.cardColors(
            containerColor = Color.White

        ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(7.dp)


    ) {

        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            Image(
                painter = painterResource(id = movie.image),
                contentDescription = movie.name,
                modifier = Modifier
                    .size(120.dp, 200.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Column(modifier.padding(12.dp)) {
                Text(
                    text = movie.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )

                Text(
                    text = movie.certification,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.Magenta
                )

                Text(
                    text = movie.starring,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Black
                )

                Text(
                    text = movie.runningTimeMins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Magenta
                )


            }
        }


    }
}