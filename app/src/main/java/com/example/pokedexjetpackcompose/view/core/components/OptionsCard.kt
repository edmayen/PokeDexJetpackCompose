package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import com.example.pokedexjetpackcompose.ui.theme.TypeGrass

@Composable
fun OptionsCard(
    text: String,
    modifier: Modifier = Modifier,
    textSize: Int = 32,
    backgroundColor: Color = Color.White,
    height: Int = 100,
    iconId: Int,
    onItemClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .clickable {
                onItemClick()
            }
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
                .height(height.dp)
                .border(3.dp, BorderBlack, RoundedCornerShape(16.dp))
                .background(backgroundColor, RoundedCornerShape(16.dp))
                .padding(24.dp)
                .align(Alignment.BottomStart)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = text,
                    fontSize = textSize.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 32.sp,
                    color = BorderBlack,
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(iconId),
                    contentDescription = "Icon"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOptionsCard() {
    OptionsCard(
        text = "Pokémon",
        backgroundColor = TypeGrass,
        iconId = R.drawable.pokeball,
        modifier = Modifier.padding(8.dp)
    )
}