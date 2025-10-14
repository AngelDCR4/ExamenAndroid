package com.app.examenandroid.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.examenandroid.presentation.screens.detail.CountryDetailScreen
import com.app.examenandroid.presentation.screens.home.HomeScreen
import com.app.examenandroid.presentation.screens.text.AboutScreen

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            HomeScreen(
                onCountryClick = { countryName ->
                    navController.navigate("detail/$countryName")
                },
                onInfoClick = {
                    navController.navigate("about")
                },
            )
        }

        composable("detail/{countryName}") { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName") ?: return@composable

            CountryDetailScreen(
                countryName = countryName,
                onBackClick = { navController.popBackStack() },
            )
        }

        composable("about") {
            AboutScreen(
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}
