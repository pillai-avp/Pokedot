package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Species(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)