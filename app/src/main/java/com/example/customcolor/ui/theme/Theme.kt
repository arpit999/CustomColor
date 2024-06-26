package com.example.customcolor.ui.theme

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Colors
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Switch
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.lightColors
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


val DarkColorPalette = darkColors(
    primary = Green400, // 0xFF00C46E
    primaryVariant = Green600,
    secondary = Green500,
    secondaryVariant = Green500,
    background = Black050,
    surface = Black100,
    error = Brown200,

    // set the onPrimary and onSecondary alpha channel by hand, here.
    // the system tries to guess the alpha channel, but the contrast ratio between
    // white and our brand green is wrong, and it stays at 1.0 alpha instead of 0.87
    onPrimary = White100.copy(alpha = 0.87f),
    onSecondary = White100.copy(alpha = 0.87f),
    // onBackground and onSurface don't have the alpha channel defined like they do in colors.xml
    // because LocalContentAlpha adjusts it dynamically.
    onBackground = White100,
    onSurface = White100,
    onError = Black050
)

// LIGHT COLOR THEME
val LightColorPalette = lightColors(
    primary = Green500,
    primaryVariant = Green500,
    secondary = Green600,
    secondaryVariant = Green600,
    background = White100,
    surface = White200,
    error = Brown500,

    onPrimary = White100,
    onSecondary = White100,
    onBackground = Black050,
    onSurface = Black050,
    onError = White100
)

class CardColors(
    val red: Color,
    val green: Color,
    val blue: Color
)

val LocalCardColors = staticCompositionLocalOf {
    CardColors(
        red = Color.Unspecified,
        green = Color.Unspecified,
        blue = Color.Unspecified
    )
}

private val DarkCardColors = CardColors(
    red = Color(0xFF009688),
    green = Color(0xFFCDDC39),
    blue = Color(0xFF673AB7)
)

private val LightCardColors = CardColors(
    red = Color(0xFF4CAF50),
    green = Color(0xFFFFEB3B),
    blue = Color(0xFF9C27B0)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val cardColors = if (darkTheme) {
        DarkCardColors
    } else {
        LightCardColors
    }

    CompositionLocalProvider(LocalCardColors provides cardColors) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

val MaterialTheme.localCardColors
    @Composable
    @ReadOnlyComposable
    get() = LocalCardColors.current

/**
 * "Secondary" text color from the xml theme, because Material 2 doesn't support it.
 * Used for subtitles & status rows.
 */
val Colors.textColorSecondary
    get() = if (isLight) {
        Black400
    } else {
        Black500
    }

val Colors.systemBlue
    get() = SystemBlue

val Colors.surfaceSecondary
    get() = if (isLight) {
        White225
    } else {
        Black75
    }

val Colors.m3OutlineVariant
    get() = onSurface.copy(alpha = 0.12f)

// The name matches the figma naming (manulife mobile/surfaces/{light/dark}/Live Chat
val Colors.m3SurfacesLiveChat
    get() = if (isLight) {
        Color(0xFFFAFAFA)
    } else {
        Color(0xFF1C1C1E)
    }

@Preview(name = "Current")
@Preview(name = "Current (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ManulifeControls() {
    AppTheme {
        Controls()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Suppress(
    "kotlin:S138", // too many lines in this function
    "kotlin:S100", // function should start with lowercase letter
)
@Composable
fun Controls(buttonColors: ButtonColors = ButtonDefaults.buttonColors()) {
    Scaffold(
        topBar = {
            TopNavBar(
                "Settings",
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* navigate to Add flow */ },
            ) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            TabRow(selectedTabIndex = 0) {
                Tab(selected = false, onClick = {}, text = {
                    Text("First Tab")
                })
                Tab(selected = false, onClick = {}, icon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "")
                })
                Tab(selected = false, onClick = {}, icon = {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                }, text = {
                    Text("Home")
                })
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                label = { Text("Name") },
                value = text,
                onValueChange = { text = it },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = MaterialTheme.colors.primary.copy(
                        alpha = ContentAlpha.high
                    )
                ),
                modifier = Modifier.fillMaxWidth()
            )

            var switched by remember { mutableStateOf(true) }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Checked", modifier = Modifier.weight(1f))
                    Switch(checked = switched, onCheckedChange = { switched = !switched })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    Switch(
                        checked = switched,
                        onCheckedChange = { switched = !switched },
                        enabled = false
                    )
                }
            }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Unchecked", modifier = Modifier.weight(1f))
                    Switch(checked = !switched, onCheckedChange = { switched = !switched })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    Switch(
                        checked = !switched,
                        onCheckedChange = { switched = !switched },
                        enabled = false
                    )
                }
            }

            var checked by remember { mutableStateOf(true) }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Checked", modifier = Modifier.weight(1f))
                    Checkbox(checked = checked, onCheckedChange = { checked = !checked })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = !checked },
                        enabled = false
                    )
                }
            }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Unchecked", modifier = Modifier.weight(1f))
                    Checkbox(checked = !checked, onCheckedChange = { checked = !checked })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = !checked,
                        onCheckedChange = { checked = !checked },
                        enabled = false
                    )
                }
            }

            var selected by remember { mutableStateOf(true) }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Checked", modifier = Modifier.weight(1f))
                    RadioButton(selected = selected, onClick = { selected = !selected })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = selected,
                        onClick = { selected = !selected },
                        enabled = false
                    )
                }
            }
            Row {
                Row(modifier = Modifier.weight(1f)) {
                    Text("Unchecked", modifier = Modifier.weight(1f))
                    RadioButton(selected = !selected, onClick = { selected = !selected })
                }
                Row(modifier = Modifier.weight(1f)) {
                    Text("Disabled", modifier = Modifier.weight(1f))
                    RadioButton(
                        selected = !selected,
                        onClick = { selected = !selected },
                        enabled = false
                    )
                }
            }

            Button(onClick = {}) {
                Text("Primary action")
            }
            OutlinedButton(onClick = {}) {
                Text("Secondary action")
            }
            TextButton(onClick = {}) {
                Text("Tertiary action")
            }
            Snackbar(snackbarData = LocalSnackbarData)
        }
    }
}

@Composable
fun TopNavBar(
    title: CharSequence,
    contentColor: Color = MaterialTheme.colors.onPrimary,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = AnnotatedString(title.toString())) },
        contentColor = contentColor,
        backgroundColor = backgroundColor,
        navigationIcon = navigationIcon,
        actions = actions
    )
}


private object LocalSnackbarData : SnackbarData {
    override val actionLabel = "Do it"
    override val duration = SnackbarDuration.Indefinite
    override val message = "Snackbar"

    override fun dismiss() {
        //do nothing
    }

    override fun performAction() {
        // do nothing
    }
}
