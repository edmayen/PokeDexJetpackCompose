package com.example.pokedexjetpackcompose.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexjetpackcompose.ui.theme.BorderBlack
import com.example.pokedexjetpackcompose.ui.theme.RetroGreen

@Composable
fun RetroButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(x = 6.dp, y = 8.dp)
                .background(BorderBlack, RoundedCornerShape(16.dp))
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = RetroGreen),
            border = BorderStroke(3.dp, BorderBlack),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = text,
                color = BorderBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }

}