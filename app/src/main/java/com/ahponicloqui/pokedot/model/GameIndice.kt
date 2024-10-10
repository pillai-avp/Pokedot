package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndice(
    @SerialName("game_index")
    val gameIndex: Int,
    @SerialName("version")
    val version: Version
)

@Serializable
data class Version(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)