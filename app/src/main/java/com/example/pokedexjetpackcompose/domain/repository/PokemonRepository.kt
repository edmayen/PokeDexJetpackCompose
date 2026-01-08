package com.example.pokedexjetpackcompose.domain.repository

import androidx.paging.PagingData
import com.example.pokedexjetpackcompose.data.api.response.PokemonResponse
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(limit: Int = 20, offset: Int = 0): Flow<PagingData<PokeListModel>>


    suspend fun getPokemonDetail(name: String): Resource<PokemonResponse>

}