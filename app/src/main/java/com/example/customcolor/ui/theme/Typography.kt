package com.example.customcolor.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        // (0.5 tracking / 16sp font size) = 0.03125 em
        letterSpacing = 0.03125.em
    ),

    body2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.0178571429.em
    ),

    // disclaimer, information
    caption = TextStyle(
        // textColor secondary
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.0333333333.em
    ),

    button = TextStyle(
        // fonts/Roboto-Medium.ttf
        // all caps
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.0892857143.em,
    ),

    h1 = TextStyle(
        // textColor secondary
        // fonts/Roboto-Light.ttf
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
        fontSize = 96.sp,
        letterSpacing = (-0.015625).em
    ),

    h2 = TextStyle(
        // textColor secondary
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
        fontSize = 60.sp,
        letterSpacing = (-0.00833333333).em
    ),

    h3 = TextStyle(
        // textColor secondary
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.em
    ),

    h4 = TextStyle(
        // textColor secondary
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.00735294118.em
    ),

    h5 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.em
    ),

    h6 = TextStyle(
        // fonts/Roboto-Medium.ttf
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.0125.em
    ),

    subtitle1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.009375.em
    ),

    subtitle2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.00714285714.em
    ),

    overline = TextStyle(
        // all caps
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.033333333.em
    ),
)

val Typography.h5Light
    get() = h5.copy(fontWeight = FontWeight.Light)

val Typography.body1Medium
    get() = body1.copy(fontWeight = FontWeight.Medium)
val Typography.body1Bold
    get() = body1.copy(fontWeight = FontWeight.Bold)

val Typography.body2Medium
    get() = body2.copy(fontWeight = FontWeight.Medium)

val Typography.h6Regular
    get() = h6.copy(fontWeight = FontWeight.Normal)

val Typography.subtitle2Regular
    get() = subtitle2.copy(fontWeight = FontWeight.Normal)

val Typography.m3BodyLarge
    get() = body1

val Typography.m3BodyMedium
    get() = body2

val Typography.m3BodySmall
    get() = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        letterSpacing = 0.033333333.em
    )

val Typography.m3LabelLarge
    get() = body2.copy(fontWeight = FontWeight.Bold)


@Preview(
    showBackground = true,
    heightDp = 1000,
    widthDp = 500
)
@Composable
fun TypographyPreview() {
    val styles = listOf(
        Typography::h1 to "Headline 1",
        Typography::h2 to "Headline 2",
        Typography::h3 to "Headline 3",
        Typography::h4 to "Headline 4",
        Typography::h5 to "Headline 5",
        Typography::h5Light to "Headline 5 Light",
        Typography::h6 to "Headline 6",
        Typography::h6Regular to "Headline 6 Regular",
        Typography::body1 to "Body 1",
        Typography::body1Medium to "Body 1 Medium",
        Typography::body1Bold to "Body 1 Bold",
        Typography::body2 to "Body 2",
        Typography::body2Medium to "Body 2 Medium",
        Typography::subtitle1 to "Subtitle 1",
        Typography::subtitle2 to "Subtitle 2",
        Typography::subtitle2Regular to "Subtitle 2 Regular",
        Typography::button to "Button",
        Typography::caption to "Caption",
        Typography::overline to "Overline",
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(styles) { (ref, name) ->
            val style = ref.get()
            Text(
                text = name,
                style = style
            )
        }
    }
}
