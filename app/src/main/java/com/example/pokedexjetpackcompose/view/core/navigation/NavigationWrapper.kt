package com.example.pokedexjetpackcompose.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.pokedexjetpackcompose.view.dashboard.DashboardScreen
import com.example.pokedexjetpackcompose.view.pokelist.PokeListScreen
import com.example.pokedexjetpackcompose.view.pokestart.PokeStartScreen

@Composable
fun NavigationWrapper() {
    val backStack = remember { mutableStateListOf<Any>(PokeStart) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()
        },
        entryProvider = { key ->
            when(key) {
                is PokeStart -> NavEntry(key) {
                    PokeStartScreen(
                        navigateToDashboard = {
                            backStack.add(Dashboard)
                        }
                    )
                }
                is Dashboard -> NavEntry(key) {
                    DashboardScreen(
                        navigateToPokeList = {
                            backStack.add(PokeList)
                        }
                    )
                }
                is PokeList -> NavEntry(key) {
                    PokeListScreen()
                }
                is PokemonDetail -> NavEntry(key) {

                }
                else -> NavEntry(key = Unit) {

                }
            }
        }
    )

}