package com.example.pokedexjetpackcompose.data.api.response

import kotlinx.serialization.SerialName

data class PokemonResponse(
    val abilities: List<Ability>,
    @SerialName("base_experience") val baseExperience: Int,
    val cries: Cries,
    val forms: List<Form>,
    @SerialName("game_indices") val gameIndices: List<GameIndice>,
    val height: Int,
    @SerialName("held_items") val heldItems: List<Any?>,
    val id: Int,
    @SerialName("is_default") val isDefault: Boolean,
    @SerialName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerialName("past_abilities") val pastAbilities: List<PastAbility>,
    @SerialName("past_types") val pastTypes: List<Any?>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

data class Ability(
    val ability: AbilityX,
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int
)

data class Cries(
    val latest: String,
    val legacy: String
)

data class Form(
    val name: String,
    val url: String
)

data class GameIndice(
    @SerialName("game_index") val gameIndex: Int,
    val version: Version
)

data class Move(
    val move: MoveX,
    @SerialName("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)

data class PastAbility(
    val abilities: List<AbilityXX>,
    val generation: Generation
)

data class Species(
    val name: String,
    val url: String
)

data class Sprites(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any,
    val other: Other,
    val versions: Versions
)

data class Stat(
    @SerialName("base_stat") val baseStat: Int,
    val effort: Int,
    val stat: StatX
)

data class Type(
    val slot: Int,
    val type: TypeX
)

data class AbilityX(
    val name: String,
    val url: String
)

data class Version(
    val name: String,
    val url: String
)

data class MoveX(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    @SerialName("level_learned_at") val levelLearnedAt: Int,
    @SerialName("move_learn_method") val moveLearnMethod: MoveLearnMethod,
    val order: Int,
    @SerialName("version_group") val versionGroup: VersionGroup
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class AbilityXX(
    val ability: Any,
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int
)

data class Generation(
    val name: String,
    val url: String
)

data class Other(
    @SerialName("dream_world") val dreamWorld: DreamWorld,
    val home: Home,
    @SerialName("official-artwork") val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)

data class Versions(
    @SerialName("generation-i") val generationI: GenerationI,
    @SerialName("generation-ii") val generationII: GenerationIi,
    @SerialName("generation-iii") val generationIII: GenerationIii,
    @SerialName("generation-iv") val generationIv: GenerationIv,
    @SerialName("generation-v") val generationV: GenerationV,
    @SerialName("generation-vi") val generationVi: GenerationVi,
    @SerialName("generation-vii") val generationVii: GenerationVii,
    @SerialName("generation-viii") val generationViii: GenerationViii
)

data class DreamWorld(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any
)

data class Home(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class OfficialArtwork(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
)

data class Showdown(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("back_shiny_female") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class GenerationI(
    @SerialName("red-blue") val redBlue: RedBlue,
    val yellow: Yellow
)

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)

data class GenerationIii(
    val emerald: Emerald,
    @SerialName("firered-leafgreen") val fireredLeafGreen: FireredLeafgreen,
    @SerialName("ruby-sapphire") val rubySapphire: RubySapphire
)

data class GenerationIv(
    @SerialName("diamond-pearl") val diamondPearl: DiamondPearl,
    @SerialName("heartgold-soulsilver") val heartGoldSoulSilver: HeartgoldSoulsilver,
    val platinum: Platinum
)

data class GenerationV(
    @SerialName("black-white") val blackWhite: BlackWhite
)

data class GenerationVi(
    @SerialName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegarubyAlphasapphire,
    @SerialName("x-y") val xY: XY
)

data class GenerationVii(
    val icons: Icons,
    @SerialName("ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoon
)

data class GenerationViii(
    val icons: Icons
)

data class RedBlue(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_gray") val backGray: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_gray") val frontGray: String,
    @SerialName("front_transparent") val frontTransparent: String
)

data class Yellow(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_gray") val backGray: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_gray") val frontGray: String,
    @SerialName("front_transparent") val frontTransparent: String
)

data class Crystal(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_transparent") val backShinyTransparent: String,
    @SerialName("back_transparent") val backTransparent: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_transparent") val frontShinyTransparent: String,
    @SerialName("front_transparent") val frontTransparent: String
)

data class Gold(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_transparent") val frontTransparent: String
)

data class Silver(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_transparent") val frontTransparent: String
)

data class Emerald(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
)

data class FireredLeafgreen(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
)

data class RubySapphire(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
)

data class DiamondPearl(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class HeartgoldSoulsilver(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class Platinum(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class BlackWhite(
    val animated: Animated,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class Animated(
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: Any,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backShinyFemale: Any,
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class OmegarubyAlphasapphire(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class XY(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class Icons(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
)

data class UltraSunUltraMoon(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: Any,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontShinyFemale: Any
)

data class StatX(
    val name: String,
    val url: String
)

data class TypeX(
    val name: String,
    val url: String
)