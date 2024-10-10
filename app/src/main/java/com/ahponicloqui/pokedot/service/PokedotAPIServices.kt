package com.ahponicloqui.pokedot.service

import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.repository.PokedotRepository
import kotlinx.coroutines.flow.Flow

interface PokedotServices {
    fun todaysPokemon() : Flow<NetworkResult<Pokemon>>
}

class PokedotServiceHandler(private val repository: PokedotRepository) : PokedotServices{
    override fun todaysPokemon(): Flow<NetworkResult<Pokemon>> = repository.getPokemon(id = 589)

}