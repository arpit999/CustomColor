package com.example.customcolor.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.customcolor.components.getColorFor
import com.example.customcolor.screens.model.offerList
import com.example.customcolor.ui.theme.AppTheme

@Composable
fun HomeScreen(onCardClick: (index: Int, offerId: Int) -> Unit) {
    Column {
        LazyRow(
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            itemsIndexed(offerList) { index, offer ->
                Card(
                    modifier = Modifier
                        .clickable { onCardClick(index, offer.id) }
                        .width(280.dp)
                        .height(180.dp)
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clip(MaterialTheme.shapes.large)
                                .background(getColorFor(index = index).copy(alpha = 0.3F))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                imageVector = Icons.Filled.Info,
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = offer.highlight)
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = offer.title,
                            style = MaterialTheme.typography.h5
                        )
                    }
                }
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun PreviewHomeScreen() {
    AppTheme {
        HomeScreen() { _, _ -> }
    }
}

@PreviewLightDark
@Composable
private fun PreviewHomeScreenNoTheme() {
    AppTheme {
        HomeScreen() { _, _ -> }
    }
}