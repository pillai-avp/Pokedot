package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("abilities")
    val abilities: List<Ability>,
    @SerialName("base_experience")
    val baseExperience: Int,
    @SerialName("weight")
    val weight: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("is_default")
    val isDefault: Boolean,
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String,
    @SerialName("name")
    val name: String,
    @SerialName("order")
    val order: Int,
    @SerialName("stats")
    val stats: List<Stat>,
    @SerialName("types")
    val types: List<Type>,
    @SerialName("forms")
    val forms: List<Form>,
    @SerialName("moves")
    val moves: List<Move>,
    @SerialName("sprites")
    val sprites: Sprites,
    @SerialName("species")
    val species: Species,
    /*
    @SerialName("cries")
    val cries: Cries,
    @SerialName("game_indices")
    val gameIndices: List<GameIndice>,
    @SerialName("held_items")
    val heldItems: List<String>,
    */

)