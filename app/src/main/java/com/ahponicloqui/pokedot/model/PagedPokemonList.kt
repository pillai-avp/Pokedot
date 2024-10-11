package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedPokemonList(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<Result>
)