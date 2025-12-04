package com.example.pokedexjetpackcompose.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexjetpackcompose.view.pokestart.PokeStartScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PokeStart) {
        composable<PokeStart>  {
            PokeStartScreen()
        }

    }

}