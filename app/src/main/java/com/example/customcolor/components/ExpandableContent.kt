@file:OptIn(ExperimentalMaterialApi::class)

package com.example.customcolor.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.key.Key.Companion.Help
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.customcolor.Help

@Composable
fun ExpandableContent() {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "ExpandableContentAnimation"
    )
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "Terms & Conditions")
            Spacer(modifier = Modifier.height(extraPadding))
            if (expanded) {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                            "ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
                            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
                            "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                            "culpa qui officia deserunt mollit anim id est laborum."
                )
            }
            OutlinedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}


/**
 * Expandable and collapsable card for the FAQ screen.
 * Each card is expanded by default.
 * @param item A [Help] containing the question and answer to be displayed in the card
 * @param modifier A modifier used by the card
 * @param titleTextStyle A style for the title or [TextStyle.Default] is none is specified
 * @param bodyTextStyle A style for the body or [TextStyle.Default] is none is specified
 * @param titleColor A color for the title or [MaterialTheme.colors.onBackground]
 * @param bodyColor A color for the body or [Color.Unspecified]
 * @param cardShape A shape to be used for the card, or Shapes.medium
 * @param padding The padding to be used on the card's modified, or 0.dp
 * @param onExpanded The callback used when the card is clicked
 */
@Composable
fun ExpandableCard(
    item: Help,
    modifier: Modifier = Modifier,
    titleTextStyle: TextStyle = TextStyle.Default,
    bodyTextStyle: TextStyle = TextStyle.Default,
    titleColor: Color = MaterialTheme.colors.onBackground,
    bodyColor: Color = Color.Unspecified,
    cardShape: Shape = MaterialTheme.shapes.medium,
    padding: Dp = 0.dp,
    onExpanded: (Help) -> Unit,
) {
    //Animate expandable arrow button in card
    val rotationState by animateFloatAsState(
        targetValue = if (item.isExpandable) 180f else 0f, label = "rotation"
    )

    Card(
        modifier = modifier
            .padding(padding)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 400,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = cardShape,
        backgroundColor = MaterialTheme.colors.background,
        onClick = {
            onExpanded(item)
        }
    ) {
        Column(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = modifier
                        .padding(start = 24.dp)
                        .weight(6f),
                    text = item.question,
                    style = titleTextStyle,
                    color = titleColor
                )
                Icon(
                    modifier = modifier
                        .padding(end = 16.dp)
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState)
                        .align(Alignment.Top),
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
            if (item.isExpandable) {
                Text(
                    modifier = modifier.padding(
                        top = 4.dp,
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 8.dp
                    ),
                    text = item.answer,
                    style = bodyTextStyle,
                    color = bodyColor,
                )
            }
        }
    }
    Divider()
}


@Preview
@Composable
private fun PreviewExpandableCard() {
    var item by remember {
        mutableStateOf( Help(question = "aliquam", answer = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
                "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
                "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.", isExpandable = false))
    }

    ExpandableCard(item,
        onExpanded = {
            item = item.copy(isExpandable = !it.isExpandable)
        }
    )
}

@Preview
@Composable
private fun PreviewExpandable() {
    ExpandableContent()
}