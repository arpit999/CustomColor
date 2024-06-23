package com.example.customcolor.ui.theme

import androidx.annotation.ColorRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.core.graphics.ColorUtils

val X = Color(0xFFFFFFFF)

val Green100 = Color(0xFFCAEED9)
val Green200 = Color(0xFFACE5C4)
val Green300 = Color(0xFF5CD790)
val Green400 = Color(0xFF00C46E) // [dark-primary]
val Green500 = Color(0xFF00A758) // primary, primaryVariant [dark-secondary] [dark-secondary-variant]
val Green600 = Color(0xFF06874E) // secondary, secondary_variant
val Green700 = Color(0xFF046138)
val Green800 = Color(0xFF004427) // PrimaryTransparent

val White100 = Color(0xFFFFFFFF) // on-error, onPrimary,  onSecondary, background
val White200 = Color(0xFFF5F5F5) // surface
val White225 = Color(0xFFF2F2F2) // surface-secondary

// color for dark theme
val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)

val Black500 = Color(0xFF9D9D9D) // dark text-secondary
val Black400 = Color(0xFF7B7B7B) // light text-secondary
val Black100 = Color(0xFF262626) // [dark-surface]
val Black75 = Color(0xFF1C1C1C) // [dark-surface-secondary]
val Black050 = Color(0xFF000000) // onBackground, onSurface [dark-background]

val Brown200= Color(0xFFCF6679) // [dark-error]
val Brown500 = Color(0xFFB00020) // error

val Gray100 = Color(0xFFFAFAFA) // disclaimer
val Gray200 = Color(0xFFE0E0E0) // divider
val Gray300 = Color(0xFFCCCCCC)
val Gray400 = Color(0xFF888888)
val ChevronGray = Color(0xFFCAC4D0)

val SystemBlue = Color(0xFF0077FF)
val manulifeGreen = Green500

val IconDark = Color(0xFF5A5A5A) // icons in rows
val GrayBackground = Color(0xFFBABBC1) // gray color for insight

// Once we move to M3, this should be migrated to one of the Material colours (it should be one of our main ones.. maybe)
val Navy = Color(0xFF34384B)
// Once we move to M3, this should be migrated to one of the Material colours (it should be one of our main ones.. maybe)
val GrayNavy = Color(0xFF8E90A2)

val light1Navy = Color(0xFF34384B)
val light2Navy = Color(0xFF424559)
val light3Navy = Color(0xFF5E6073)

/**
 * Calculates a high-contrast color for content showing on a non-typical background.
 * [androidx.compose.material.contentColorFor] looks for [background] in `background`, `primary`, `surface` etc
 * and returns the matching `on...` field. This method tests the contrast ratio instead, and so might return
 * a different value.
 */
@Composable
@ReadOnlyComposable
fun contrastColourFor(background: Color): Color {
    // test `onError` instead of onPrimary
    // because both the Light and Dark themes use white for `onPrimary`
    // but `onError` is always the opposite of `onBackground`.
    val onErrorContrast = ColorUtils.calculateContrast(MaterialTheme.colors.onError.toArgb(), background.toArgb())
    val onBackgroundContrast = ColorUtils.calculateContrast(MaterialTheme.colors.onBackground.toArgb(), background.toArgb())

    return if (onErrorContrast >= onBackgroundContrast) {
        MaterialTheme.colors.onError
    } else {
        MaterialTheme.colors.onBackground
    }
}

@Composable
@ReadOnlyComposable
fun contrastColourFor(@ColorRes background: Int) = contrastColourFor(colorResource(background))
