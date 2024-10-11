package com.ahponicloqui.pokedot.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
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
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun ChildHomeScreen(
    modifier: Modifier = Modifier,
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
                PokemonListItem(pokemon)
                HorizontalDivider()
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
private fun PokemonListItem(pokemon: Result?) {
    Text(
        modifier = Modifier
            .padding(vertical = 30.dp),
        textAlign = TextAlign.Left,
        text = pokemon?.name?.capitalize(LocaleList.current) ?: "",
    )
}
