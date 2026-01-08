package com.example.pokedexjetpackcompose.view.pokelist

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.domain.usecases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    val pokemonList: Flow<PagingData<PokeListModel>> = getPokemonListUseCase()

}