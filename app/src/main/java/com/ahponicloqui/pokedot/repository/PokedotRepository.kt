package com.ahponicloqui.pokedot.repository

import com.ahponicloqui.pokedot.api.PokedotAPI
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.common.asResult
import com.ahponicloqui.pokedot.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedotRepository {
    fun getPokemon(id: Int): Flow<NetworkResult<Pokemon>>
}

class PokedotDataSource(private val api: PokedotAPI) : PokedotRepository{
    override fun getPokemon(id: Int) : Flow<NetworkResult<Pokemon>> = asResult {
        api.getPokemon(id)
    }
}