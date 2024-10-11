package com.ahponicloqui.pokedot.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.ahponicloqui.pokedot.base.BaseViewModel
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.service.PokedotServices
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ParentHomeViewModel(private val services: PokedotServices) :
    BaseViewModel<ParentHomeUIEvent>() {
    val viewState: StateFlow<NetworkResult<Pokemon>> = services.pokemon.asState(
        NetworkResult.Loading)

    init {
        getRandomPokemon()
    }

    private fun getRandomPokemon() {
        viewModelScope.launch {
            services.getTodaysPokemon()
        }
    }

    override fun handleEvent(event: ParentHomeUIEvent) {
        when (event) {
            is ParentHomeUIEvent.Random -> getRandomPokemon()
            is ParentHomeUIEvent.SendToKids -> TODO()
        }
    }
}