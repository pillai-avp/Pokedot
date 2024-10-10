package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class XY(
    @SerialName("front_default")
    val frontDefault: String,

    @SerialName("front_shiny")
    val frontShiny: String,

)