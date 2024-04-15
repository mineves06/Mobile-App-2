package com.student25460.movieapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "HomePage",
    ) {
        composable(route = "HomePage")
        {
            CinemaHomePage(
                movies,
                navController = navController
            )
        }
        composable("MoviesPage/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            MoviesPage(
                movies = movies,
                movieId = backStackEntry.arguments?.getInt("movieId")?: -1,
                navController = navController ,
                modifier = Modifier)

        }
    }
}
