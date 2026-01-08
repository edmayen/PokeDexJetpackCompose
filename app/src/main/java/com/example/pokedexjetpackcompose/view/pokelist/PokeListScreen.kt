package com.example.pokedexjetpackcompose.view.pokelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedexjetpackcompose.ui.theme.RetroBeige
import com.example.pokedexjetpackcompose.ui.theme.TypeGrass
import com.example.pokedexjetpackcompose.view.core.components.DottedBackground
import com.example.pokedexjetpackcompose.view.core.components.PokeListItem
import com.example.pokedexjetpackcompose.view.core.components.TopAppBar

@Composable
fun PokeListScreen(
    viewModel: PokeListViewModel = hiltViewModel(),
    navigateBack: () -> Unit = {}
) {
    val pokemonList = viewModel.pokemonList.collectAsLazyPagingItems()

    Scaffold(
        containerColor = RetroBeige
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            DottedBackground()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                TopAppBar(
                    title = "Pokedex",
                    onBackClick = { navigateBack() }
                )
                when {
                    pokemonList.loadState.refresh is LoadState.Loading && pokemonList.itemCount == 0 -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp),
                                color = TypeGrass
                            )
                        }
                    }

                    pokemonList.loadState.refresh is LoadState.NotLoading && pokemonList.itemCount == 0 -> {

                    }

                    pokemonList.loadState.hasError -> {

                    }

                    else -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            state = rememberLazyGridState(),
                            verticalArrangement = Arrangement.spacedBy(20.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(
                                top = 16.dp,
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 24.dp
                            )
                        ) {
                            items(pokemonList.itemCount) {
                                pokemonList[it]?.let { pokemon ->
                                    PokeListItem(pokemon = pokemon)
                                }
                            }
                        }
                        if (pokemonList.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}