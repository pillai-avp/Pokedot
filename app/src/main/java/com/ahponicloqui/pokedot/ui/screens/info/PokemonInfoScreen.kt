package com.ahponicloqui.pokedot.ui.screens.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.ahponicloqui.pokedot.R
import com.ahponicloqui.pokedot.common.screens.HandleResult
import com.ahponicloqui.pokedot.common.screens.KeyValues
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.ui.PokedotNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonInfoScreen(
    modifier: Modifier = Modifier,
    pokedotNavController: PokedotNavController,
    pokemonId: Int?,
    viewModel: PokemonInfoViewModel = koinViewModel()
) {
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {
    }) { paddingValues ->
        val state = viewModel.viewState.collectAsStateWithLifecycle()
        LaunchedEffect(Unit) {
            pokemonId?.let {
                viewModel.sendEvent(PokemonInfoUIEvents.Opened(it))
            }

        }
        state.HandleResult { value ->
            PokemonInformation(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), pokemon = value
            )
        }
    }
}

@Composable
fun PokemonInformation(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = pokemon.sprites.other.officialArtwork.frontShiny,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = pokemon.name.capitalize(localeList = LocaleList.current),
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        HorizontalDivider()
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.national_no),
            value = pokemon.id.toString()
        )
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.type),
            value = pokemon.types.map { it.type.name }.reduce { acc, t ->
                "$acc , $t"
            })
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.species),
            value = pokemon.species.name
        )
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.height),
            value = pokemon.height.toString()
        )
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.weight),
            value = pokemon.weight.toString()
        )
        KeyValues(
            modifier = Modifier,
            key = stringResource(R.string.abilities),
            values = pokemon.abilities.map { it.ability.name })

    }
}