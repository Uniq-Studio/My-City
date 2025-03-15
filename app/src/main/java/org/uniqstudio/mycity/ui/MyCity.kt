package org.uniqstudio.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.RestaurantViewModel
import org.uniqstudio.mycity.ui.screens.RestaurantScreen
import org.uniqstudio.mycity.ui.screens.WelcomeScreen
import androidx.navigation.compose.composable

enum class MyCityScreens(@StringRes val title: Int){
    Welcome(title = R.string.welcome_to),
    Restaurant(title = R.string.restaurant_title),
}


@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    windowSize: WindowSizeClass,
){
    NavHost(
        navController = navController,
        startDestination = MyCityScreens.Welcome.name
    ){
        composable(route = MyCityScreens.Welcome.name) {
            WelcomeScreen(
                windowSize = windowSize,
                onClickNext = { navController.navigate(MyCityScreens.Restaurant.name) }
            )
        }
        composable(route = MyCityScreens.Restaurant.name) {
            RestaurantScreen(
                restaurantViewModel = RestaurantViewModel(),
                windowSize = windowSize,
            )
        }
    }
}