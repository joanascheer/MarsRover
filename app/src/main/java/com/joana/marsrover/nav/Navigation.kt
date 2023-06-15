package com.joana.marsrover.nav

import androidx.navigation.NavController
import com.joana.marsrover.nav.Destinations.HOME

object Destinations {
    const val HOME: String = "home"
    const val MANIFEST = "manifest/{roverName"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(HOME) }
    val manifest: (roverName: String) -> Unit =
        { roverName ->
        navController.navigate("manifest/${roverName}")
        }

}