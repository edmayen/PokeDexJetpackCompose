package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DottedBackground(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val dotRadius = 1.5.dp.toPx()
        val spacing = 20.dp.toPx()
        for(x in 0 until size.width.toInt() step spacing.toInt()) {
            for (y in 0 until size.height.toInt() step spacing.toInt()) {
                drawCircle(
                    color = Color.Gray.copy(alpha = 0.3f),
                    radius = dotRadius,
                    center = Offset(x = x.toFloat(), y = y.toFloat())
                )
            }
        }
    }
}