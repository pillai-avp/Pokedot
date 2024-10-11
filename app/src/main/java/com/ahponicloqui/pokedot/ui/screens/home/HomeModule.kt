package com.ahponicloqui.pokedot.ui.screens.home

import com.ahponicloqui.pokedot.ui.screens.info.PokemonInfoViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::ParentHomeViewModel)
    viewModelOf(::ChildHomeViewModel)
    viewModelOf(::PokemonInfoViewModel)
}