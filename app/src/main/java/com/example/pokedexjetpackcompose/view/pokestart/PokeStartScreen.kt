package com.example.pokedexjetpackcompose.view.pokestart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexjetpackcompose.R
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack
import com.example.pokedexjetpackcompose.ui.theme.RetroBeige
import com.example.pokedexjetpackcompose.view.core.components.DottedBackground
import com.example.pokedexjetpackcompose.view.core.components.GameBoyCard
import com.example.pokedexjetpackcompose.view.core.components.RetroButton

@Preview(showBackground = true)
@Composable
fun PokeStartScreen(
    navigateToDashboard: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RetroBeige)
    ) {
        DottedBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.pokemon_logo),
                contentDescription = "Pokeball",
                modifier = Modifier
                    .align(Alignment.Start)
                    .width(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            GameBoyCard(modifier = Modifier)
            Spacer(modifier = Modifier.height(24.dp))
            InfoCard(modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            RetroButton(
                text = "Get Started!",
                onClick = { navigateToDashboard() },
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = 6.dp, y = 8.dp)
                .background(BorderBlack, RoundedCornerShape(16.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(3.dp, BorderBlack, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(24.dp)
        ) {
            Text(
                text = "Know everything\nabout Pokemon\nand Enjoy!",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 32.sp,
                color = BorderBlack
            )
        }
    }

}