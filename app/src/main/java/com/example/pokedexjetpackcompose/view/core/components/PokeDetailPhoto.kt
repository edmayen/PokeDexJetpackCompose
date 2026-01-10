package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack
import com.example.pokedexjetpackcompose.ui.theme.PokeballRed
import com.example.pokedexjetpackcompose.ui.theme.PokeballWhite
import com.example.pokedexjetpackcompose.ui.theme.ScreenBlue
import com.example.pokedexjetpackcompose.ui.theme.TypeWater

@Preview(showBackground = true)
@Composable
fun PokeDetailPhoto(
    pokemonPhotoUrl: String = "",
    modifier: Modifier = Modifier
) {
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
                .clip(RoundedCornerShape(16.dp))
                .border(3.dp, BorderBlack, RoundedCornerShape(16.dp))
                .background(TypeWater)
                .padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            PokeballBackground(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
                    .fillMaxSize(0.85f)
            )
            AsyncImage(
                model = pokemonPhotoUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun PokeballBackground(
    modifier: Modifier = Modifier

) {
    Canvas(modifier = modifier) {
        val strokeWidth = 10f
        val lineColor: Color = Color.Black
        val canvasWidth = size.width
        val canvasHeight = size.height
        val centerY = canvasHeight / 2

        drawArc(
            color = PokeballRed,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(0f, 0f),
            size = size
        )

        drawArc(
            color = PokeballWhite,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(0f, 0f),
            size = size
        )

        drawLine(
            color = lineColor,
            start = Offset(0f, centerY),
            end = Offset(canvasWidth, centerY),
            strokeWidth = strokeWidth
        )

        drawCircle(
            color = lineColor,
            radius = canvasWidth / 2,
            style = Stroke(width = strokeWidth)
        )

        drawCircle(
            color = lineColor,
            radius = canvasWidth * 0.18f
        )

        drawCircle(
            color = PokeballWhite,
            radius = canvasWidth * 0.15f
        )

        drawCircle(
            color = Color.LightGray,
            radius = canvasWidth * 0.14f,
            style = Stroke(width = 2f)
        )
    }
}
