package org.uniqstudio.mycity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.data.RestaurantDataSource
import org.uniqstudio.mycity.model.Restaurant

@Composable
fun RestaurantScreen(){
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
                    { isShowingList = !isShowingList })
            } else {
                InfoPanel(
                    image = RestaurantDataSource().loadRestaurants()[0].imageResourceId,
                    title = RestaurantDataSource().loadRestaurants()[0].name,
                    description = RestaurantDataSource().loadRestaurants()[0].description,
                    subText1 = RestaurantDataSource().loadRestaurants()[0].location,
                    subText2 = RestaurantDataSource().loadRestaurants()[0].rating,
                )
            }
        }
    }
}

@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
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
                onClick = onClick
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

