package com.example.pokedexjetpackcompose.view.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexjetpackcompose.R
import com.example.pokedexjetpackcompose.ui.theme.RetroBeige
import com.example.pokedexjetpackcompose.ui.theme.TypeElectric
import com.example.pokedexjetpackcompose.ui.theme.TypeGhost
import com.example.pokedexjetpackcompose.ui.theme.TypeGrass
import com.example.pokedexjetpackcompose.view.core.components.DottedBackground
import com.example.pokedexjetpackcompose.view.core.components.OptionsCard

@Preview(showBackground = true)
@Composable
fun DashboardScreen(
    navigateToPokeList: () -> Unit = {}
) {
    Scaffold (
        topBar = {},
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(RetroBeige)
                    .padding(paddingValues)
            ) {
                DottedBackground()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.End)
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = "What are \n you looking for?",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 32.sp,
                        color = Color.Black
                    )
                    Spacer(Modifier.height(24.dp))
                    Text(
                        text = "Add search here",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 32.sp,
                        color = Color.Black
                    )
                    Spacer(Modifier.height(24.dp))
                    OptionsCard(
                        text = "Pokémon",
                        backgroundColor = TypeGrass,
                        height = 120,
                        iconId = R.drawable.pokeball,
                        onItemClick = {
                            navigateToPokeList()
                        }
                    )
                    Spacer(Modifier.height(32.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OptionsCard(
                            text = "Type",
                            textSize = 24,
                            backgroundColor = TypeElectric,
                            height = 100,
                            iconId = R.drawable.thunder,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(Modifier.width(24.dp))
                        OptionsCard(
                            text = "Fav",
                            textSize = 24,
                            backgroundColor = TypeGhost,
                            height = 100,
                            iconId = R.drawable.love,
                            modifier = Modifier.weight(1f)
                        )
                    }

                }
            }
        }
    )
}