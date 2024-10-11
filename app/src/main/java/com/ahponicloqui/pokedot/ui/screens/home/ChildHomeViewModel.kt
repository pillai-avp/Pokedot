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
    fun getPokemons(): Flow<PagingData<Result>> = services.pokemons().cachedIn(viewModelScope)

    /*
        private val _viewState = MutableStateFlow<NetworkResult<PagedResult>>(NetworkResult.Loading)
        val viewState: StateFlow<NetworkResult<PagedResult>> = _viewState.asStateFlow()

        init {
            fetchPokemonList()
        }

        private fun fetchPokemonList(offset: Int = 0, limit: Int = 10) {
            viewModelScope.launch {
                services.fetchPokemonList(offset, limit).collect {
                    _viewState.emit(it)
                }
            }
        }*/

    override fun handleEvent(event: ChildHomeUIEvent) {
        super.handleEvent(event)
    }
}