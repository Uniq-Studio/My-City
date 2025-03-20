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
import org.uniqstudio.mycity.model.Place
import org.uniqstudio.mycity.model.PlaceViewModel
import org.uniqstudio.mycity.ui.HorizontalImageInfoCard
import org.uniqstudio.mycity.ui.InfoPanel
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun PlaceScreen(
    screenName: Int,
    place: List<Place>,
    onClickBack: () -> Unit,
    viewModel: PlaceViewModel,
    windowSize: WindowSizeClass
) {
    val placeUiState by viewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = screenName,
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
                        PlaceList(
                            place,
                            viewModel,
                            { isShowingList = !isShowingList }
                        )
                    } else {
                        InfoPanel(
                            image = placeUiState.bannerResourceId,
                            title = placeUiState.name,
                            description = placeUiState.description,
                            subText1 = placeUiState.location,
                            subText2 = placeUiState.rating,
                        )
                    }
                }


                else -> {
                    PlaceListAndInfo(
                        place,
                        viewModel,
                        {},
                        placeUiState.bannerResourceId,
                        placeUiState.name,
                        placeUiState.description,
                        placeUiState.location,
                        placeUiState.rating
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceList(
    place: List<Place>,
    viewModel: PlaceViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(place) { place ->
            PlaceCard(
                place = place,
                onClick = {
                    viewModel.updateInfoPanel(
                        bannerResourceId = place.bannerResourceId,
                        name = place.name,
                        description = place.description,
                        location = place.location,
                        rating = place.rating
                    )
                    onClick()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun PlaceListAndInfo(
    place: List<Place>,
    viewModel: PlaceViewModel,
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
        PlaceList(
            place = place,
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
fun PlaceCard(
    place: Place,
    onClick: () -> Unit
){
    HorizontalImageInfoCard(
        image = place.imageResourceId,
        title = place.name,
        description = place.description,
        subText1 = place.location,
        subText2 = place.rating,
        onClick = onClick,
    )
}