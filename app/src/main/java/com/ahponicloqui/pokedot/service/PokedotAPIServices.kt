package com.ahponicloqui.pokedot.service

import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.repository.PokedotRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.Date
import kotlin.random.Random

interface PokedotServices {
    val todaysPokemon: SharedFlow<NetworkResult<Pokemon>>
    suspend fun getRandomPokemon()
}

class PokedotServiceHandler(private val repository: PokedotRepository) : PokedotServices {
    private val _todaysPokemon = MutableSharedFlow<NetworkResult<Pokemon>>()
    override val todaysPokemon: SharedFlow<NetworkResult<Pokemon>> = _todaysPokemon.asSharedFlow()
    private val random: Random = Random(Date().time)

    override suspend fun getRandomPokemon() {
        repository.getPokemon(id = random.nextInt(1..1036)).collect {
            _todaysPokemon.emit(it)
        }
    }
}

fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start + 1)
}