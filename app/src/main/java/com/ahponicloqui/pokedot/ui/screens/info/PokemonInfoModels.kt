package com.ahponicloqui.pokedot.ui.screens.info

sealed interface PokemonInfoUIEvents {
    data class Opened(val id: Int) : PokemonInfoUIEvents
}