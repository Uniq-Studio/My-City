package org.uniqstudio.mycity.ui

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
import org.uniqstudio.mycity.data.RestaurantDataSource
import org.uniqstudio.mycity.model.Restaurant
import org.uniqstudio.mycity.model.RestaurantViewModel

@Composable
fun RestaurantScreen(
    restaurantViewModel: RestaurantViewModel,
    windowSize: WindowSizeClass
) {
    val restaurantUiState by restaurantViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.app_name,
                goBack = true,
                onClickBack = { isShowingList = true }
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
                        { isShowingList = !isShowingList },
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