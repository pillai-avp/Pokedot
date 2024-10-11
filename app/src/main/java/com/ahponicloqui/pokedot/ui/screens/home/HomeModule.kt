package com.ahponicloqui.pokedot.ui.screens.home

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::ParentHomeViewModel)
    viewModelOf(::ChildHomeViewModel)
}