package org.uniqstudio.mycity.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.data.restaurant.RestaurantDataSource
import org.uniqstudio.mycity.model.restaurant.Restaurant
import org.uniqstudio.mycity.model.restaurant.RestaurantViewModel
import org.uniqstudio.mycity.ui.HorizontalImageInfoCard
import org.uniqstudio.mycity.ui.InfoPanel
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun RestaurantScreen(
    onClickBack: () -> Unit,
    restaurantViewModel: RestaurantViewModel,
    windowSize: WindowSizeClass
) {
    val restaurantUiState by restaurantViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.restaurants,
                goBack = true,
                onClickBack = {
                    if (isShowingList) {
                        onClickBack()
                    }
                    isShowingList = true
                }
            )
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ) {
            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
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


                else -> {
                    RestaurantListAndInfo(
                        RestaurantDataSource().loadRestaurants(),
                        restaurantViewModel,
                        {},
                        restaurantUiState.bannerResourceId,
                        restaurantUiState.name,
                        restaurantUiState.description,
                        restaurantUiState.location,
                        restaurantUiState.rating
                    )
                }
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
                    viewModel.updateInfoPanel(
                        bannerResourceId = restaurant.bannerResourceId,
                        name = restaurant.name,
                        description = restaurant.description,
                        location = restaurant.location,
                        rating = restaurant.rating
                    )
                    onClick()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun RestaurantListAndInfo(
    restaurants: List<Restaurant>,
    viewModel: RestaurantViewModel,
    onClick: () -> Unit,
    image: Int,
    title: Int,
    description: Int,
    subText1: Int,
    subText2: Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .padding(5.dp)
    ){
        RestaurantList(
            restaurants = restaurants,
            viewModel = viewModel,
            onClick = onClick,
            modifier = modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Box(
            modifier = modifier
                .weight(2f)
        ) {
            InfoPanel(
                image = image,
                title = title,
                description = description,
                subText1 = subText1,
                subText2 = subText2
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