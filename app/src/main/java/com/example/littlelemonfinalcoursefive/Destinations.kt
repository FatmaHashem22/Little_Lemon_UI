package com.example.littlelemonfinalcoursefive

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "Home"
}

object DishDetails : Destinations {
    override val route = "MenuItem"
    const val argDishID = "dishID"
}