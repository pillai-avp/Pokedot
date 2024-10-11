package com.ahponicloqui.pokedot.ui.screens.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ahponicloqui.pokedot.base.BaseViewModel
import com.ahponicloqui.pokedot.model.Result
import com.ahponicloqui.pokedot.service.PokedotServices
import kotlinx.coroutines.flow.Flow

class ChildHomeViewModel(private val services: PokedotServices) :
    BaseViewModel<ChildHomeUIEvent>() {
    fun getPokemons(): Flow<PagingData<Result>> =
        services.pagedPokemonList().cachedIn(viewModelScope)

    override fun handleEvent(event: ChildHomeUIEvent) {
        when (event) {
            is ChildHomeUIEvent.OnClickChildListItem -> TODO()
        }
    }
}