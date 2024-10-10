package com.ahponicloqui.pokedot.ui.screens.home

import com.ahponicloqui.pokedot.base.BaseViewModel
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.service.PokedotServices
import kotlinx.coroutines.flow.StateFlow

class ParentHomeViewModel(private val services: PokedotServices) :
    BaseViewModel<ParentHomeUIEvent>() {
    val viewState: StateFlow<NetworkResult<Pokemon>> = services.todaysPokemon().asState(
        NetworkResult.Loading)

    override fun handleEvent(event: ParentHomeUIEvent) {
        when (event) {
            else -> {}
        }
    }
}