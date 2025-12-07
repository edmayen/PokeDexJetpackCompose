package com.example.pokedexjetpackcompose.data.repository

import com.example.pokedexjetpackcompose.data.api.ApiService
import com.example.pokedexjetpackcompose.data.api.response.PokeListResponse
import com.example.pokedexjetpackcompose.data.api.response.PokemonResponse
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.domain.repository.PokemonRepository
import com.example.pokedexjetpackcompose.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokeListResponse> =
        withContext(Dispatchers.IO) {
            val response = try {
                val response = apiService.getPokemonList()
                Resource.Success(response)
            } catch (e: Exception) {
                Resource.Error(e.message ?: "Unknown error")
            }
            response
        }

    override suspend fun getPokemonDetail(name: String): Resource<PokemonResponse> =
        withContext(Dispatchers.IO) {
            val response = try {
                val response = apiService.getPokemonDetail(name)
                Resource.Success(response)
            } catch (e: Exception) {
                Resource.Error(e.message ?: "Unknown error")
            }
            response
        }
}