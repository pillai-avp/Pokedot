package com.ahponicloqui.pokedot.service

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ahponicloqui.pokedot.common.NetworkResult
import com.ahponicloqui.pokedot.model.Pokemon
import com.ahponicloqui.pokedot.model.Result
import com.ahponicloqui.pokedot.repository.PokedotRepository
import com.ahponicloqui.pokedot.ui.screens.home.PokemonPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.Date
import kotlin.random.Random

interface PokedotServices {
    val pokemon: SharedFlow<NetworkResult<Pokemon>>
    suspend fun getTodaysPokemon()
    suspend fun getPokemonWithID(id: Int)
    fun pagedPokemonList(): Flow<PagingData<Result>>
}

class PokedotServiceHandler(private val repository: PokedotRepository) : PokedotServices {
    private val _pokemon = MutableSharedFlow<NetworkResult<Pokemon>>()
    override val pokemon: SharedFlow<NetworkResult<Pokemon>> = _pokemon.asSharedFlow()
    private val random: Random = Random(Date().time)

    override suspend fun getTodaysPokemon() {
        repository.getPokemon(id = random.nextInt(1..1036)).collect {
            _pokemon.emit(it)
        }
    }

    override suspend fun getPokemonWithID(id: Int) {
        repository.getPokemon(id).collect {
            _pokemon.emit(it)
        }
    }

    override fun pagedPokemonList() = Pager(
        config = PagingConfig(
            pageSize = 20,
        ),
        pagingSourceFactory = {
            PokemonPagingSource(repository)
        }
    ).flow
}

fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start + 1)
}