package com.ahponicloqui.pokedot.ui.screens.home

import com.ahponicloqui.pokedot.model.Pokemon

sealed interface ParentHomeUIEvent{

}

sealed interface ParentHomeViewState{
    data object Loading : ParentHomeViewState
    data class Error(val message : String) : ParentHomeViewState
    data class Success(val pokemon : Pokemon) : ParentHomeViewState

}