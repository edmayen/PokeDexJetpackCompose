package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack

@Composable
fun RedDot(
    modifier: Modifier = Modifier,
    size: Dp = 10.dp
) {
    Box(
        modifier = modifier
            .size(size = size)
            .clip(CircleShape)
            .border(1.5.dp, BorderBlack, CircleShape)
            .background(Color(0xFFE53935))
    ) { }
}