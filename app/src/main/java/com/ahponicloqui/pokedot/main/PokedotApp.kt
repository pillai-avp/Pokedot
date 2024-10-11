@file:OptIn(
    ExperimentalSharedTransitionApi::class
)

package com.ahponicloqui.pokedot.main

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahponicloqui.pokedot.ui.Destinations
import com.ahponicloqui.pokedot.ui.rememberPokedotNavController
import com.ahponicloqui.pokedot.ui.screens.home.ChildHomeScreen
import com.ahponicloqui.pokedot.ui.screens.home.ParentHomeScreen
import com.ahponicloqui.pokedot.ui.screens.info.PokemonInfoScreen
import com.ahponicloqui.pokedot.ui.screens.login.LoginScreen
import com.ahponicloqui.pokedot.ui.theme.PokedotTheme

val LocalNavAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }

@Composable
fun PokedotApp() {
    PokedotTheme {
        val pokedotNavController = rememberPokedotNavController()
        SharedTransitionLayout {
            CompositionLocalProvider(
                LocalSharedTransitionScope provides this
            ) {
                NavHost(
                    navController = pokedotNavController.navController,
                    startDestination = Destinations.LOGIN_ROUTE
                ) {
                    composable(Destinations.LOGIN_ROUTE) {
                        LoginScreen(modifier = Modifier, pokedotNavController)
                    }
                    composable(Destinations.PARENT_HOME_ROUTE) {
                        ParentHomeScreen(modifier = Modifier, pokedotNavController)
                    }

                    composable(Destinations.CHILD_HOME_ROUTE) {
                        ChildHomeScreen(modifier = Modifier, pokedotNavController)
                    }

                    composable(
                        "${Destinations.CHILD_POKEMON_INFO_ROUTE}/{id}",
                        arguments = listOf(navArgument(name = "id") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id")
                        PokemonInfoScreen(modifier = Modifier, pokedotNavController, pokemonId = id)
                    }
                }
            }
        }
    }
}
