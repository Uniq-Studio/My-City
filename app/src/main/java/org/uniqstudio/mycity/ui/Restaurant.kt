package org.uniqstudio.mycity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.data.RestaurantDataSource
import org.uniqstudio.mycity.model.Restaurant
import org.uniqstudio.mycity.model.RestaurantViewModel

@Composable
fun RestaurantScreen(
    restaurantViewModel: RestaurantViewModel
){
    val restaurantUiState by restaurantViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.app_name,
                goBack = true,
                onClickBack = {isShowingList = true}
            )
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ){
            if (isShowingList) {
                RestaurantList(
                    RestaurantDataSource().loadRestaurants(),
                    restaurantViewModel,
                    { isShowingList = !isShowingList }
                )
            } else {
                InfoPanel(
                    image = restaurantUiState.bannerResourceId,
                    title = restaurantUiState.name,
                    description = restaurantUiState.description,
                    subText1 = restaurantUiState.location,
                    subText2 = restaurantUiState.rating,
                )
            }
        }
    }
}

@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
    viewModel: RestaurantViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(restaurants) { restaurant ->
            RestaurantCard(
                restaurant = restaurant,
                onClick = {
                    viewModel.UpdateInfoPanel(
                        bannerResourceId = restaurant.bannerResourceId,
                        name = restaurant.name,
                        description = restaurant.description,
                        location = restaurant.location,
                        rating = restaurant.rating
                    )
                    onClick()
                }
            )
        }
    }
}

@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onClick: () -> Unit
){
    HorizontalImageInfoCard(
        image = restaurant.imageResourceId,
        title = restaurant.name,
        description = restaurant.description,
        subText1 = restaurant.location,
        subText2 = restaurant.rating,
        onClick = onClick,
    )
}

