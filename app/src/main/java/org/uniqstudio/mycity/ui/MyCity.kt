package org.uniqstudio.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.ui.screens.WelcomeScreen
import androidx.navigation.compose.composable
import org.uniqstudio.mycity.data.datasource.CafeDataSource
import org.uniqstudio.mycity.data.datasource.KidFriendlyDataSource
import org.uniqstudio.mycity.data.datasource.ParkDataSource
import org.uniqstudio.mycity.data.datasource.RestaurantDataSource
import org.uniqstudio.mycity.data.datasource.ShoppingCenterSource
import org.uniqstudio.mycity.model.PlaceViewModel
import org.uniqstudio.mycity.ui.screens.ListOfActions
import org.uniqstudio.mycity.ui.screens.PlaceScreen

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

    val cafeDataSource = CafeDataSource()
    val restaurantDataSource = RestaurantDataSource()
    val kidFriendlyDataSource = KidFriendlyDataSource()
    val parkDataSource = ParkDataSource()
    val shoppingCenterSource = ShoppingCenterSource()

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
            PlaceScreen(
                screenName = R.string.coffee_shops,
                place = cafeDataSource.loadCafes(),
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                viewModel = PlaceViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.Restaurant.name) {
            PlaceScreen(
                screenName = R.string.restaurants,
                place = restaurantDataSource.loadRestaurants(),
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                viewModel = PlaceViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.KidFriendly.name) {
            PlaceScreen(
                screenName = R.string.kid_friendly_places,
                place = kidFriendlyDataSource.loadKidFriendly(),
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                viewModel = PlaceViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.Parks.name) {
            PlaceScreen(
                screenName = R.string.parks,
                place = parkDataSource.loadPark(),
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                viewModel = PlaceViewModel(),
                windowSize = windowSize,
            )
        }
        composable(route = MyCityScreens.ShoppingCenters.name) {
            PlaceScreen(
                screenName = R.string.shopping_centers,
                place = shoppingCenterSource.loadShops(),
                onClickBack = { navController.navigate(MyCityScreens.ListOfActions.name) },
                viewModel = PlaceViewModel(),
                windowSize = windowSize,
            )
        }
    }
}