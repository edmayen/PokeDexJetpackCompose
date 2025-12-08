package com.example.pokedexjetpackcompose.domain.repository

import com.example.pokedexjetpackcompose.data.api.response.PokemonResponse
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.utils.Resource

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int = 20, offset: Int = 0): Resource<List<PokeListModel>>

    suspend fun getPokemonDetail(name: String): Resource<PokemonResponse>

}