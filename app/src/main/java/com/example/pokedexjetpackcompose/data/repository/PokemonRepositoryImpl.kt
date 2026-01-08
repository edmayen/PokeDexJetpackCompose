package com.example.pokedexjetpackcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSourceFactory
import com.example.pokedexjetpackcompose.data.PokemonPagingSource
import com.example.pokedexjetpackcompose.data.api.ApiService
import com.example.pokedexjetpackcompose.data.api.response.PokemonResponse
import com.example.pokedexjetpackcompose.data.api.response.toDomain
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.domain.repository.PokemonRepository
import com.example.pokedexjetpackcompose.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonRepository {

    override fun getPokemonList(limit: Int, offset: Int):  Flow<PagingData<PokeListModel>> {
        return Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 3),
            pagingSourceFactory = {
                PokemonPagingSource(apiService)
            }
        ).flow
    }
//        withContext(Dispatchers.IO) {
//            val response = try {
//                val response = apiService.getPokemonList()
//                val model = response.results?.map { it.toDomain() } ?: emptyList()
//                Resource.Success(model)
//            } catch (e: Exception) {
//                Resource.Error(e.message ?: "Unknown error")
//            }
//            response
//        }

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