package com.example.pokedexjetpackcompose.domain.model

import androidx.compose.ui.graphics.Color


data class PokeListModel(
    val pokemonId: String,
    val pokemonName: String,
    val imageUrl: String,
    val number: String,
    val backgroundColor: Color
)