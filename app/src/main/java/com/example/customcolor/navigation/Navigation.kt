package com.example.customcolor.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.customcolor.R
import com.example.customcolor.screens.HomeScreen
import com.example.customcolor.screens.OfferDetailsScreen
import com.example.customcolor.screens.model.offerList


sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    data object Home : Screen("Home", R.string.Home)
    object OfferDetails : Screen("OfferDetails/{${Args.id}}", R.string.offer_details){
        fun createRoute(id: Int) = "OfferDetails/$id"
    }
    object Args {
        const val id = "id"
    }
}

@Composable
fun NavigationApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCardClick = { id ->
                    navController.navigate(Screen.OfferDetails.createRoute(id))
                }
            )
        }
        composable(
            route = Screen.OfferDetails.route,
            arguments = listOf(navArgument(Screen.Args.id) { type = NavType.IntType })
        ) { backStackEntry ->
            val offer = offerList[backStackEntry.arguments?.getInt(Screen.Args.id) ?: 0]
            OfferDetailsScreen(offer)
        }
    }
}

