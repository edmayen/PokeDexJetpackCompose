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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexjetpackcompose.R
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack
import com.example.pokedexjetpackcompose.ui.theme.GameBoyGrey
import com.example.pokedexjetpackcompose.ui.theme.ScreenBlue

@Preview(showBackground = true)
@Composable
fun GameBoyCard(modifier: Modifier = Modifier) {
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
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(3.dp, BorderBlack, RoundedCornerShape(16.dp))
                    .background(GameBoyGrey)
                    .padding(vertical = 24.dp, horizontal = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(48.dp)
                ) {
                    RedDot(size = 16.dp)
                    RedDot(size = 16.dp)
                }
                Spacer(Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .border(3.dp, BorderBlack, RoundedCornerShape(12.dp))
                        .background(ScreenBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.squirtle),
                        contentDescription = "Game Boy",
                        modifier = Modifier
                            .size(220.dp)
                            .background(Color.Transparent)
                    )
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RedDot(size = 24.dp)
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Game Boy",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = (-6).dp, y = (-4).dp)
                    .clip(RoundedCornerShape(50))
                    .border(3.dp, BorderBlack, RoundedCornerShape(50))
                    .background(Color.White)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(text = "#007", fontWeight = FontWeight.Bold)
            }
        }
    }

}

