package org.uniqstudio.mycity.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.uniqstudio.mycity.model.Restaurant

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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
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