package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedexjetpackcompose.R
import com.example.pokedexjetpackcompose.domain.model.PokeListModel
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack
import com.example.pokedexjetpackcompose.ui.theme.GameBoyGreyV2
import com.example.pokedexjetpackcompose.ui.theme.TypeFire

@Composable
fun PokeListItem(
    pokemon: PokeListModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(170.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = 6.dp, y = 8.dp)
                .background(BorderBlack, RoundedCornerShape(16.dp))
        )
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, BorderBlack, RoundedCornerShape(16.dp))
                    .background(GameBoyGreyV2)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    RedDot(size = 8.dp)
                    Spacer(modifier = Modifier.width(16.dp))
                    RedDot(size = 8.dp)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(3.dp, BorderBlack, RoundedCornerShape(12.dp))
                        .background(pokemon.backgroundColor),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokedex_background),
                        contentDescription = "Pokeball",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                    )
                    AsyncImage(
                        model = pokemon.imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(0.9f)

                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RedDot(size = 12.dp)
                    Text(
                        text = pokemon.pokemonName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
                    )
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Game Boy",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = (-8).dp, y = (-6).dp)
                    .clip(RoundedCornerShape(50))
                    .border(3.dp, BorderBlack, RoundedCornerShape(50))
                    .background(Color.White)
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    text = pokemon.number,
                    fontSize = 10.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokeListItem() {
    PokeListItem(
        pokemon = PokeListModel(
            pokemonName = "Bulbasaur",
            imageUrl = "",
            number = "001",
            backgroundColor = TypeFire,
        )
    )
}