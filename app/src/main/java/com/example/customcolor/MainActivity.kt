package com.example.customcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.customcolor.navigation.NavigationApp
import com.example.customcolor.screens.OfferDetailsScreen
import com.example.customcolor.screens.model.offerList
import com.example.customcolor.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    OfferDetails(modifier = Modifier.padding(innerPadding))
//                    HomeScreen(modifier = Modifier.padding(innerPadding))
                    NavigationApp(innerPadding)
                }
            }
        }
    }
}