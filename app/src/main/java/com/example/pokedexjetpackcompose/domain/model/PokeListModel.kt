package com.example.pokedexjetpackcompose.domain.model


data class PokeListModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokeListResultModel>
)

data class PokeListResultModel(
    val name: String,
    val url: String
)