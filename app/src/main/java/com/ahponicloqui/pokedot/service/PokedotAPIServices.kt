package com.ahponicloqui.pokedot.service

import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.repository.PokedotRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import kotlin.random.Random

interface PokedotServices {
    fun todaysPokemon(): Flow<NetworkResult<Pokemon>>
}

class PokedotServiceHandler(private val repository: PokedotRepository) : PokedotServices {
    val random: Random = Random(Date().time)
    override fun todaysPokemon(): Flow<NetworkResult<Pokemon>> =
        repository.getPokemon(id = random.nextInt(1..1036))
}

fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start + 1)
}