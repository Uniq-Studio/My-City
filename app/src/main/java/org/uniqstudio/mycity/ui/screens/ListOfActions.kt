package org.uniqstudio.mycity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.ui.BlankSpaceFiller
import org.uniqstudio.mycity.ui.BoldTitleText
import org.uniqstudio.mycity.ui.SmallTextTitle
import org.uniqstudio.mycity.ui.TitleText
import org.uniqstudio.mycity.ui.WideButtonBar

@Composable
fun ListOfActions(
    onClickCoffeeShops: () -> Unit,
    onClickRestaurants: () -> Unit,
    onClickKidFriendlyPlaces: () -> Unit,
    onClickParks: () -> Unit,
    onClickShoppingCenters: () -> Unit,
    windowSize: WindowSizeClass
){
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            ListOfActionsPortrait(
                onClickCoffeeShops = onClickCoffeeShops,
                onClickRestaurants = onClickRestaurants,
                onClickKidFriendlyPlaces = onClickKidFriendlyPlaces,
                onClickParks = onClickParks,
                onClickShoppingCenters = onClickShoppingCenters
            )
        }
        else -> {
            ListOfActionsLandscape(
                onClickCoffeeShops = onClickCoffeeShops,
                onClickRestaurants = onClickRestaurants,
                onClickKidFriendlyPlaces = onClickKidFriendlyPlaces,
                onClickParks = onClickParks,
                onClickShoppingCenters = onClickShoppingCenters
            )
        }
    }
}

@Composable
fun ListOfActionsPortrait(
    onClickCoffeeShops: () -> Unit,
    onClickRestaurants: () -> Unit,
    onClickKidFriendlyPlaces: () -> Unit,
    onClickParks: () -> Unit,
    onClickShoppingCenters: () -> Unit
){
    Column(
    ) {
        TitleText(R.string.loa_title)
        BoldTitleText(R.string.loa_subtext)

        Spacer(modifier = Modifier.size(30.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            WideButtonBar(text = R.string.coffee_shops, bold = false, onClick = onClickCoffeeShops)
            WideButtonBar(text = R.string.restaurants, bold = false, onClick = onClickRestaurants)
            WideButtonBar(text = R.string.kid_friendly_places, bold = false, onClick = onClickKidFriendlyPlaces)
            WideButtonBar(text = R.string.parks, bold = false, onClick = onClickParks)
            WideButtonBar(text = R.string.shopping_centers, bold = false, onClick = onClickShoppingCenters)
        }
    }
}

@Composable
fun ListOfActionsLandscape(
    onClickCoffeeShops: () -> Unit,
    onClickRestaurants: () -> Unit,
    onClickKidFriendlyPlaces: () -> Unit,
    onClickParks: () -> Unit,
    onClickShoppingCenters: () -> Unit
){
    Row(
        modifier = Modifier.padding(20.dp)
    ){
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Column{
                BlankSpaceFiller()

                TitleText(R.string.welcome_to)
                BoldTitleText(R.string.my_city)
                SmallTextTitle(R.string.glasgow)

                BlankSpaceFiller()
            }
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            ListOfActionsPortrait(
                onClickCoffeeShops = onClickCoffeeShops,
                onClickRestaurants = onClickRestaurants,
                onClickKidFriendlyPlaces = onClickKidFriendlyPlaces,
                onClickParks = onClickParks,
                onClickShoppingCenters = onClickShoppingCenters
            )
        }
    }
}

@Preview
@Composable
fun ListOfActionsPreview(){
    ListOfActionsLandscape({},{},{},{},{})
}