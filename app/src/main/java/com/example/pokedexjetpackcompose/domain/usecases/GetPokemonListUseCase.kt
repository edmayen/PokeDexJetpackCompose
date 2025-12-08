package com.example.pokedexjetpackcompose.domain.usecases

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import com.example.pokedexjetpackcompose.data.api.response.PokeListResponse
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.domain.repository.PokemonRepository
import com.example.pokedexjetpackcompose.utils.Resource
import com.example.pokedexjetpackcompose.utils.extractLastNumber
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokeRepository: PokemonRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<PokeListModel>>> =
        flow {
            val result = pokeRepository.getPokemonList()
            if (result is Resource.Success) {
                emit(result)
            } else {
                emit(result)
            }
        }

    private fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}