package com.example.customcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.core.text.parseAsHtml
import androidx.core.text.toHtml
import coil.compose.AsyncImage
import com.example.customcolor.components.DisplayHTMLText
import com.example.customcolor.ui.theme.ManulifeBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManulifeBankTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OfferDetails(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun OfferDetails(modifier: Modifier = Modifier) {
    Column {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = "https://dummyimage.com/600x400/000/fff.png&text=hello",
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            IconButton(modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .background(MaterialTheme.colors.surface),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = null)
            }
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .clip(MaterialTheme.shapes.large)
                    .background(MaterialTheme.colors.primaryVariant.copy(alpha = 0.3F))
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
                Text(text = "Limited time offer")
            }

            Text(
                text = "You're pre-approved for a higher limit on your card.",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))

            val htmlString = "<p>Congrats! You qualify for a credit limit increase of <strong>\$4,500</strong> on your \n" +
                    "    <em>ManulifeMONEY+Visa* *****9876</em>.</p> <br>" +
                    "<p>By clicking ‘Accept now’, you agree and consent to increasing your credit limit to \n" +
                    "    <strong>\$15,000</strong>.</p>"
            Text(
                text = DisplayHTMLText(htmlString),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ManulifeBankTheme {
        OfferDetails()
    }
}