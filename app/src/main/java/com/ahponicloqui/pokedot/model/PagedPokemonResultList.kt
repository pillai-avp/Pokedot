package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedPokemonResultList(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<Result>
)

@Serializable
data class PagedPokemonList(
    val count: Int,
    val next: String,
    val previous: String? = null,
    val results: List<Pokemon>
)