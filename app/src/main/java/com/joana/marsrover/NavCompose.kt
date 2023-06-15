package com.joana.marsrover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joana.marsrover.nav.Action
import com.joana.marsrover.nav.Destinations.HOME
import com.joana.marsrover.nav.Destinations.MANIFEST
import com.joana.marsrover.ui.theme.MarsRoverTheme
import com.joana.marsrover.ui.view.ManifestScreen
import com.joana.marsrover.ui.view.RoverList

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    
    MarsRoverTheme {
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) {
                RoverList() {roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(MANIFEST) { entry ->
                ManifestScreen(
                    roverName = entry.arguments?.getString("roverName")
                )
            }
        }
        
    }
}