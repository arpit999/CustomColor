package com.example.customcolor.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.customcolor.ui.theme.localCardColors

@Composable
fun getColorFor(index: Int): Color {
    val colors = listOf(
        MaterialTheme.localCardColors.red,
        MaterialTheme.localCardColors.green,
        MaterialTheme.localCardColors.blue
    )

    return colors[index % colors.size]
}