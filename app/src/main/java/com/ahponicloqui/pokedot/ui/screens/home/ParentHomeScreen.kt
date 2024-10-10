package com.ahponicloqui.pokedot.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.ahponicloqui.pokedot.common.screens.HandleResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.ui.PokedotNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun ParentHomeScreen(
    modifier: Modifier = Modifier,
    pokedotNavController: PokedotNavController,
    viewModel: ParentHomeViewModel = koinViewModel()
) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {

    }) { paddingValues ->
        val state = viewModel.viewState.collectAsStateWithLifecycle()
        state.HandleResult { value ->
            PokemonHighlightedInformation(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), value
            )
        }
    }

}

@Composable
fun PokemonHighlightedInformation(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Column(modifier = modifier) {
        AsyncImage(
            model = pokemon.sprites.other.officialArtwork.frontShiny,
            contentDescription = null,
        )
    }
}