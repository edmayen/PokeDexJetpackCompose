package com.example.pokedexjetpackcompose.view.pokelist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexjetpackcompose.domain.usecases.GetPokemonListUseCase
import com.example.pokedexjetpackcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(PokeListUiState())
    val uiState = _uiState
        .onStart {
            getPokemonList()
        }
        .stateIn (
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = PokeListUiState()
        )

    fun getPokemonList() {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isLoading = true)
            }
            getPokemonListUseCase().collect { result ->
                when(result) {
                    is Resource.Success -> {
                        _uiState.update { state ->
                            Log.e("POKEMON_LIST_SERVICE", result.data.toString())
                            state.copy(
                                isLoading = false,
                                pokemonList = result.data ?: emptyList()
                            )
                        }
                    }
                    is Resource.Error -> {
                        Log.e("POKEMON_LIST_SERVICE_ERROR", result.message ?: "Unknown error")
                    }
                    else -> {}
                }
            }
        }
    }

}