package com.ahponicloqui.pokedot.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ahponicloqui.pokedot.R
import com.ahponicloqui.pokedot.model.Result
import com.ahponicloqui.pokedot.ui.Destinations
import com.ahponicloqui.pokedot.ui.PokedotNavController
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun ChildHomeScreen(
    modifier: Modifier = Modifier,
    pokedotNavController: PokedotNavController,
    viewModel: ChildHomeViewModel = koinViewModel()
) {
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {

    }) { paddingValues ->
        val pokemons = viewModel.getPokemons().collectAsLazyPagingItems()
        LazyColumn(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            items(
                items = pokemons,
                key = { it.url }
            ) { pokemon ->
                pokemon?.let {
                    PokemonListItem(it, onClick = { event ->
                        pokedotNavController.navController.navigate(Destinations.CHILD_POKEMON_INFO_ROUTE)
                    })
                    HorizontalDivider()
                }
            }

            when (val state = pokemons.loadState.refresh) {
                is LoadState.Error -> {
                    Timber.d(state.error)
                }

                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = stringResource(R.string.refresh_loading)
                            )
                            CircularProgressIndicator()
                        }
                    }
                }

                else -> {

                }
            }

            when (pokemons.loadState.append) { // Pagination
                is LoadState.Error -> {

                }

                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = stringResource(R.string.pagination_loading))
                            CircularProgressIndicator()
                        }
                    }
                }

                else -> {}
            }
        }
    }
}

@Composable
private fun PokemonListItem(pokemon: Result, onClick: (ChildHomeUIEvent) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick(ChildHomeUIEvent.OnClickChildListItem(pokemon.url))
        }) {
        Text(
            modifier = Modifier
                .padding(vertical = 30.dp),
            textAlign = TextAlign.Left,
            text = pokemon.name.capitalize(LocaleList.current),
        )
    }

}
