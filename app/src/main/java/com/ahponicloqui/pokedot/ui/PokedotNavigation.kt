package com.ahponicloqui.pokedot.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

object Destinations{
    const val PARENT_HOME_ROUTE = "parent-home"
    const val LOGIN_ROUTE = "login"
    const val CHILD_HOME_ROUTE = "child-home"
    const val CHILD_POKEMON_INFO_ROUTE = "child-pokemon_info"
}



@Composable
fun rememberPokedotNavController(
    navController: NavHostController = rememberNavController()
): PokedotNavController = remember(navController) {
    PokedotNavController(navController)
}

/**
 * Responsible for holding UI Navigation logic.
 */
@Stable
class PokedotNavController(
    val navController: NavHostController,
){

    fun upPress() {
        navController.navigateUp()
    }

    private fun NavBackStackEntry.lifecycleIsResumed() =
        this.lifecycle.currentState == Lifecycle.State.RESUMED

    private val NavGraph.startDestination: NavDestination?
        get() = findNode(startDestinationId)

}