package com.example.customcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.customcolor.components.DisplayHTMLText
import com.example.customcolor.components.ExpandableContent
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
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
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

            val htmlString =
                "<p>Congrats! You qualify for a credit limit increase of <strong>\$4,500</strong> on your \n" +
                        "    <em>ManulifeMONEY+Visa* *****9876</em>.</p> <br>" +
                        "<p>By clicking ‘Accept now’, you agree and consent to increasing your credit limit to \n" +
                        "    <strong>\$15,000</strong>.</p>"
            Text(
                text = DisplayHTMLText(htmlString),
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableContent(
                defaultExpansion = false,
                titleContent = { expanded ->
                    val expandedTitle = "Show Less"
                    val collapsedTitle = "Show More"
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp),
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.AddCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )

                    Text(text = if (expanded) expandedTitle else collapsedTitle)
                },
                onExpand = {
                    val body = """
                <h4>Terms and Conditions</h4>
                <br>
                <p>Last updated: 2023-11-16</p>
                <br>
                <h5>1. Acceptance of Terms</h5>
                <br>
                <p>By accessing and using this website, you agree to be bound by these Terms and Conditions. If you do not agree with any part of these terms, you must not use this website.</p>
                <br><h5>2. Use of the Website</h5>
                <br>
                <p>You may use this website for personal, non-commercial purposes only. You must not use this website in any way that causes, or may cause, damage to the website or impairment of the availability or accessibility of the website.</p>
                <br>
                <h5>3. Intellectual Property</h5>
                <br>
                <p>All content on this website, including text, graphics, logos, and images, is the property of the website owner and is protected by copyright laws. You may not reproduce, distribute, or modify any content without prior written permission.</p>
                <br>
                <h5>4. Disclaimer of Warranties</h5>
                <br>
                <p>This website is provided "as is" without any warranties, express or implied. The website owner makes no representations or warranties of any kind, including but not limited to the accuracy, completeness, or reliability of the content.</p>
                <br>
                <h5>5. Limitation of Liability</h5>
                <br>
                <p>The website owner shall not be liable for any damages, including direct, indirect, incidental, or consequential damages, arising out of or in connection with the use of this website.</p>
                <br>
                <h5>6. Governing Law</h5>
                <br>
                <p>These Terms and Conditions shall be governed by and construed in accordance with the laws of [Your Jurisdiction].</p>
                <br>
                <h5>7. Changes to Terms</h5>
                <br>
                <p>The website owner reserves the right to modify these Terms and Conditions at any time. Any changes will be effective immediately upon posting on this website.</p>
                <br>
                <p>If you have any questions about these Terms and Conditions, please contact us at [Your Contact Information].</p>
            """
                    Text(text = DisplayHTMLText(body), style = MaterialTheme.typography.caption)
                }
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