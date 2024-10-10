package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedResult(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String,
    @SerialName("results")
    val results: List<Result>
)

@Serializable
data class Result(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)