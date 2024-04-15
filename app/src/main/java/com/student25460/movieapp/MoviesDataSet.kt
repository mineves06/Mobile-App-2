package com.student25460.movieapp


data class Movie(


    val id: Int,
    val name: String,
    val image: Int,
    val certification: String,
    val description: String,
    val starring: String,
    val runningTimeMins: String,
    var seatsRemaining: Int = (0..15).random(),
    var seatsSelected: Int = 0

)



val movies = listOf(
    Movie(1, "THE AVENGERS", R.drawable.avengers, "PG-13",
        "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
        "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth", "143 min", 5, 10),
    Movie(2, "BARBIE", R.drawable.barbie, "12A",
        "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
        "Margot Robbie, Ryan Gosling, America Ferrera, Will Ferrell", "114 min", 2, 13),
    Movie(3, "DUNE", R.drawable.dune, "PG-13",
        "In the distant future, Duke Leto Atreides, ruler of the planet Caladan, is assigned by the Padishah Emperor Shaddam IV to replace Baron Vladimir Harkonnen as the fiefholder of Arrakis. Leto is suspicious of the Emperor but weighs the risks against the power of controlling Arrakis and making an alliance with its mysterious natives, the Fremen",
        "Timothée Chalamet, Zendaya, Jason Momoa, Javier Bardem", "155 min", 10, 5),
    Movie(4, "HARRY POTTER", R.drawable.harrypotter, "PG-13",
        "Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and is the third in the Harry Potter series.",
        "Daniel Radcliffe, Rupert Grint, Emma Watson", "142 min", 3, 12)
)

