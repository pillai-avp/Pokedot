package com.ahponicloqui.pokedot.api

import com.ahponicloqui.pokedot.model.PagedPokemonList
import com.ahponicloqui.pokedot.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokedotAPI {

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PagedPokemonList
}