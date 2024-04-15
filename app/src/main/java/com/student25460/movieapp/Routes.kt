package com.student25460.movieapp

sealed class Routes(val route: String) {
    object HomePage : Routes("HomePage")
    object MoviesPage : Routes("MoviesPage")

}