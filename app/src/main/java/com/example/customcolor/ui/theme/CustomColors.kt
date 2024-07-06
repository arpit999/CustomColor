package com.example.customcolor.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LightCustomColorPalette = CustomColors(
    background = Color(0xFFC5F4F1),
    icon = Color(0xFF0B9189)
)

val DarkCustomColorPalette = CustomColors(
    background = Color(0xFFC5F4F1),
    icon = Color(0xFF0B9189)
)

@Immutable
data class CustomColors(
    val background: Color,
    val icon: Color
)

val LocalCustomColors = staticCompositionLocalOf { LightCustomColorPalette }