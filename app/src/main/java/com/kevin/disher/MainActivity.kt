package com.kevin.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kevin.disher.category.CategoryScreen
import com.kevin.disher.detail.DetailScreen
import com.kevin.disher.dishes.DishesScreen
import com.kevin.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}

@Composable
fun DisherApp() {
    //TODO
    /**
     * Split this NavHost
     * composables -  category screen
     * composables -  Disher screen
     */

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "detail") {
        composable(route = "category") {
            CategoryScreen { category ->
                navController.navigate("dishes/${category}")
            }
        }
        composable(route = "dishes/{categoryKey}", arguments = listOf(navArgument("categoryKey") {
            type = NavType.StringType
        })) {
            //TODO
            val categoryStr = remember {
                it.arguments?.getString("categoryKey")
            }

            DishesScreen(category = categoryStr)
        }
        composable(route = "detail") {
            DetailScreen(mealId = "52772")
        }
    }
}
