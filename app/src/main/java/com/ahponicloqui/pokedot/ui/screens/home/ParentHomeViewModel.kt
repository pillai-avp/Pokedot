package com.ahponicloqui.pokedot.ui.screens.home

import androidx.lifecycle.ViewModel
import com.ahponicloqui.pokedot.base.BaseViewModel
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.service.PokedotServices
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

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