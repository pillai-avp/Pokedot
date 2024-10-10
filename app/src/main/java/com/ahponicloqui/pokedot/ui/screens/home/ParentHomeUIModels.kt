package com.ahponicloqui.pokedot.ui.screens.home

import com.ahponicloqui.pokedot.model.Pokemon

sealed interface ParentHomeUIEvent{
    data object Random : ParentHomeUIEvent
    data class SendToKids(val pokemonId: Int) : ParentHomeUIEvent
}

sealed interface ParentHomeViewState{
    data object Loading : ParentHomeViewState
    data class Error(val message : String) : ParentHomeViewState
    data class Success(val pokemon : Pokemon) : ParentHomeViewState

}