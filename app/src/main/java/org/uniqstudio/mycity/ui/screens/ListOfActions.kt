package org.uniqstudio.mycity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.ui.BlankSpaceFiller
import org.uniqstudio.mycity.ui.BoldTitleText
import org.uniqstudio.mycity.ui.SmallTextTitle
import org.uniqstudio.mycity.ui.TappableText
import org.uniqstudio.mycity.ui.TitleText
import org.uniqstudio.mycity.ui.WideButtonBar

@Composable
fun ListOfActions(
    onClickCoffeeShops: () -> Unit,
    onClickRestaurants: () -> Unit,
    onClickKidFriendlyPlaces: () -> Unit,
    onClickParks: () -> Unit,
    onClickShoppingCenters: () -> Unit,
    onClickAbout: () -> Unit,
    windowSize: WindowSizeClass
) {
    Box {
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
        TappableText(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = R.string.about_screen,
            onClick = onClickAbout
        )
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            TitleText(R.string.loa_title)
            BoldTitleText(R.string.loa_subtext)

            Spacer(modifier = Modifier.size(30.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                WideButtonBar(
                    text = R.string.coffee_shops,
                    bold = false,
                    onClick = onClickCoffeeShops
                )
                WideButtonBar(
                    text = R.string.restaurants,
                    bold = false,
                    onClick = onClickRestaurants
                )
                WideButtonBar(
                    text = R.string.kid_friendly_places,
                    bold = false,
                    onClick = onClickKidFriendlyPlaces
                )
                WideButtonBar(text = R.string.parks, bold = false, onClick = onClickParks)
                WideButtonBar(
                    text = R.string.shopping_centers,
                    bold = false,
                    onClick = onClickShoppingCenters
                )
            }
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
            Column(

                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,) {
                Column {
                    TitleText(R.string.welcome_to)
                    BoldTitleText(R.string.my_city)
                    SmallTextTitle(text = R.string.glasgow)

                    BlankSpaceFiller()
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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