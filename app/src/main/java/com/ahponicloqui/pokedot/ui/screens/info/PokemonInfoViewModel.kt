package com.ahponicloqui.pokedot.ui.screens.info

import androidx.lifecycle.viewModelScope
import com.ahponicloqui.pokedot.base.BaseViewModel
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.service.PokedotServices
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonInfoViewModel(private val services: PokedotServices) :
    BaseViewModel<PokemonInfoUIEvents>() {
    val viewState: StateFlow<NetworkResult<Pokemon>> = services.pokemon.asState(
        NetworkResult.Loading
    )

    override fun handleEvent(event: PokemonInfoUIEvents) {
        when (event) {
            is PokemonInfoUIEvents.Opened -> viewModelScope.launch {
                services.getPokemonWithID(event.id)
            }
        }
    }
}