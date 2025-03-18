package org.uniqstudio.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.restaurant.RestaurantViewModel
import org.uniqstudio.mycity.ui.screens.RestaurantScreen
import org.uniqstudio.mycity.ui.screens.WelcomeScreen
import androidx.navigation.compose.composable
import org.uniqstudio.mycity.model.cafes.CafeViewModel
import org.uniqstudio.mycity.model.kid_friendly.KidFriendlyViewModel
import org.uniqstudio.mycity.model.parks.ParkViewModel
import org.uniqstudio.mycity.ui.screens.CafeScreen
import org.uniqstudio.mycity.ui.screens.KidFriendlyScreen
import org.uniqstudio.mycity.ui.screens.ListOfActions
import org.uniqstudio.mycity.ui.screens.ParkScreen

enum class MyCityScreens(@StringRes val title: Int){
    Welcome(title = R.string.welcome_to),
    ListOfActions(title = R.string.loa_title),
    CoffeeShop(title = R.string.coffee_shops),
    Restaurant(title = R.string.restaurant_title),
    KidFriendly(title = R.string.kid_friendly_places),
    Parks(title = R.string.parks),
    ShoppingCenters(title = R.string.shopping_centers)
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
                onClickCoffeeShops = { navController.navigate(MyCityScreens.CoffeeShop.name) },
                onClickRestaurants = { navController.navigate(MyCityScreens.Restaurant.name) },
                onClickKidFriendlyPlaces = { navController.navigate(MyCityScreens.KidFriendly.name) },
                onClickParks = { navController.navigate(MyCityScreens.Parks.name) },
                onClickShoppingCenters = { navController.navigate(MyCityScreens.ShoppingCenters.name) },
                windowSize = windowSize,
                onClickNext = { navController.navigate(MyCityScreens.ListOfActions.name) }
            )
        }
        composable(route = MyCityScreens.ListOfActions.name) {
            ListOfActions(
                onClickCoffeeShops = { navController.navigate(MyCityScreens.CoffeeShop.name) },
                onClickRestaurants = { navController.navigate(MyCityScreens.Restaurant.name) },
                onClickKidFriendlyPlaces = { navController.navigate(MyCityScreens.KidFriendly.name) },
                onClickParks = { navController.navigate(MyCityScreens.Parks.name)},
                onClickShoppingCenters = { navController.navigate(MyCityScreens.ShoppingCenters.name) },
                windowSize = windowSize
            )
        }
        composable(route = MyCityScreens.CoffeeShop.name) {
            CafeScreen(
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                cafeViewModel = CafeViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.Restaurant.name) {
            RestaurantScreen(
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                restaurantViewModel = RestaurantViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.KidFriendly.name) {
            KidFriendlyScreen(
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                kidFriendlyViewModel = KidFriendlyViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.Parks.name) {
            ParkScreen(
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                parkViewModel = ParkViewModel(),
                windowSize = windowSize,
            )
        }
    }
}