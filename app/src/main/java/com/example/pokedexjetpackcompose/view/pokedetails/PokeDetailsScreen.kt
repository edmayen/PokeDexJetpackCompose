package com.example.pokedexjetpackcompose.view.pokedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedexjetpackcompose.ui.theme.RetroBeige
import com.example.pokedexjetpackcompose.view.core.components.DottedBackground
import com.example.pokedexjetpackcompose.view.core.components.PokeDetailPhoto
import com.example.pokedexjetpackcompose.view.core.components.TopAppBar

@Composable
fun PokeDetailsScreen(
    pokemonName: String,
    navigateBack: () -> Unit
) {
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
                    title = pokemonName,
                    onBackClick = { navigateBack() }
                )
                Spacer(Modifier.height(32.dp))
                PokeDetailPhoto(
                    pokemonPhotoUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
                    modifier = Modifier.padding(horizontal = 40.dp)
                )
            }
        }
    }
}
