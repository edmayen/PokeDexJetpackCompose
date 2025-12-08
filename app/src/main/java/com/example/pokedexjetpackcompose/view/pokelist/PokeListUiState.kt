package com.example.pokedexjetpackcompose.view.pokelist

import com.example.pokedexjetpackcompose.domain.model.PokeListModel

data class PokeListUiState (
    val isLoading: Boolean = false,
    val pokemonList: List<PokeListModel> = emptyList()
)