package com.example.pokedexjetpackcompose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedexjetpackcompose.data.api.ApiService
import com.example.pokedexjetpackcompose.data.api.response.toDomain
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import java.io.IOException
import javax.inject.Inject

private const val PAGE_SIZE = 20

class PokemonPagingSource @Inject constructor(private val apiService: ApiService): PagingSource<Int, PokeListModel>() {

    override fun getRefreshKey(state: PagingState<Int, PokeListModel>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokeListModel> {
        return try {
            val page = params.key ?: 0
            val response = apiService.getPokemonList(
                limit = PAGE_SIZE,
                offset = page * PAGE_SIZE
            )
            val pokemon = response.results

            val prevKey = if (page == 0) null else page - 1
            val nextKey = if (response.next != null) page + 1 else null
            return if (pokemon.isNullOrEmpty()) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Page(
                    data = pokemon.map { it.toDomain() },
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            }
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}