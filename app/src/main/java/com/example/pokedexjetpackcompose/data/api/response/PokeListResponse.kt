package com.example.pokedexjetpackcompose.data.api.response

import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.ui.theme.TypeFire
import com.example.pokedexjetpackcompose.ui.theme.TypeNormal
import com.example.pokedexjetpackcompose.utils.capitalizeFirst
import com.example.pokedexjetpackcompose.utils.extractLastNumber
import com.example.pokedexjetpackcompose.utils.extractLastNumberAndFormat
import kotlinx.serialization.Serializable

@Serializable
data class PokeListResponse(
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = "",
    val results: List<PokeListResult>? = emptyList()
)

@Serializable
data class PokeListResult(
    val name: String? = "",
    val url: String? = ""
)

fun PokeListResult.toDomain(): PokeListModel = PokeListModel(
    pokemonName = name?.capitalizeFirst() ?: "",
    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${url?.extractLastNumber()}.png",
    number = url?.extractLastNumberAndFormat() ?: "",
    backgroundColor = TypeFire
)