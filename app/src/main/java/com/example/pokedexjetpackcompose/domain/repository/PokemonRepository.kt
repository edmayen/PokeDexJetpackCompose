package com.example.pokedexjetpackcompose.domain.repository

import com.example.pokedexjetpackcompose.data.api.response.PokeListResponse
import com.example.pokedexjetpackcompose.data.api.response.PokemonResponse
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.utils.Resource

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokeListResponse>

    suspend fun getPokemonDetail(name: String): Resource<PokemonResponse>

}