package com.ahponicloqui.pokedot.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Versions(
    @SerialName("generation-i")
    val generationI: GenerationI,
    @SerialName("generation-ii")
    val generationIi: GenerationIi,
    @SerialName("generation-iii")
    val generationIii: GenerationIii,
    @SerialName("generation-iv")
    val generationIv: GenerationIv,
    @SerialName("generation-v")
    val generationV: GenerationV,
    @SerialName("generation-vi")
    val generationVi: GenerationVi,
    @SerialName("generation-vii")
    val generationVii: GenerationVii,
    @SerialName("generation-viii")
    val generationViii: GenerationViii
)


@Serializable
data class GenerationViii(
    @SerialName("icons")
    val icons: Icons
)

@Serializable
data class Icons(
    @SerialName("front_default")
    val frontDefault: String,
)

@Serializable
data class GenerationVii(
    @SerialName("icons")
    val icons: Icons,
    @SerialName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)

@Serializable
data class UltraSunUltraMoon(
    @SerialName("front_default")
    val frontDefault: String,
    @SerialName("front_shiny")
    val frontShiny: String,
)

@Serializable
data class GenerationVi(
    @SerialName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerialName("x-y")
    val xY: XY
)

@Serializable
data class OmegarubyAlphasapphire(
    @SerialName("front_default")
    val frontDefault: String,
    @SerialName("front_shiny")
    val frontShiny: String,
)



@Serializable
data class GenerationV(
    @SerialName("black-white")
    val blackWhite: BlackWhite
)


@Serializable
data class BlackWhite(
    @SerialName("animated")
    val animated: Animated,
    @SerialName("back_default")
    val backDefault: String,
    @SerialName("back_shiny")
    val backShiny: String,
    @SerialName("front_default")
    val frontDefault: String,
    @SerialName("front_female")
    val frontShiny: String,
)

@Serializable
data class Animated(
    @SerialName("back_default")
    val backDefault: String,
    @SerialName("back_shiny")
    val backShiny: String,
    @SerialName("front_default")
    val frontDefault: String,
    @SerialName("front_shiny")
    val frontShiny: String,
)

@Serializable
data class GenerationIv(
    @SerialName("diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerialName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerialName("platinum")
    val platinum: Platinum
)

@Serializable
data class GenerationI(
    @SerialName("red-blue")
    val redBlue: RedBlue,
    @SerialName("yellow")
    val yellow: Yellow
)

@Serializable
data class GenerationIi(
    @SerialName("crystal")
    val crystal: Crystal,
    @SerialName("gold")
    val gold: Gold,
    @SerialName("silver")
    val silver: Silver
)


@Serializable
data class GenerationIii(
    @SerialName("emerald")
    val emerald: Emerald,
    @SerialName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen,
    @SerialName("ruby-sapphire")
    val rubySapphire: RubySapphire
)