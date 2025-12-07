package com.example.pokedexjetpackcompose.data.api.response

import kotlinx.serialization.Serializable

@Serializable
data class PokeListResponse(
    val count: Int? = 0,
    val next: String? = "",
    val previous: String? = "",
    val results: List<Result>? = emptyList()
)

@Serializable
data class Result(
    val name: String? = "",
    val url: String? = ""
)