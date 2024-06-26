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

    object OfferDetails : Screen("OfferDetails/{${Args.COLOR_INDEX_ARG}}/{${Args.OFFER_ID}}", R.string.offer_details) {
        fun createRoute(colorIndex: Int, id: Int) = "OfferDetails/$colorIndex/$id"
    }

    object Args {
        const val COLOR_INDEX_ARG = "colorIndexArg"
        const val OFFER_ID = "id"
    }
}

@Composable
fun NavigationApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCardClick = { colorIndex, offerId ->
                    navController.navigate(Screen.OfferDetails.createRoute(colorIndex, offerId))
                }
            )
        }
        composable(
            route = Screen.OfferDetails.route,
            arguments = listOf(
                navArgument(Screen.Args.OFFER_ID) { type = NavType.IntType },
                navArgument(Screen.Args.COLOR_INDEX_ARG) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val colorIndex = backStackEntry.arguments?.getInt(Screen.Args.COLOR_INDEX_ARG) ?: 0
            val offer = offerList.first { it.id == backStackEntry.arguments?.getInt(Screen.Args.OFFER_ID) }
            OfferDetailsScreen(colorIndex, offer, navigateToHome = { navController.popBackStack() })
        }
    }
}

