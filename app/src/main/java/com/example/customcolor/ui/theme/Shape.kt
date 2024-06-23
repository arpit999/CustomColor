@file:Suppress("packageName")

package com.example.customcolor.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(5.dp)
)

val insightActionButton = RoundedCornerShape(topStart = 14.dp)