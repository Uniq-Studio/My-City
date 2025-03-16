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
import org.uniqstudio.mycity.data.cafes.CafeDataSource
import org.uniqstudio.mycity.model.cafes.Cafe
import org.uniqstudio.mycity.model.cafes.CafeViewModel
import org.uniqstudio.mycity.ui.HorizontalImageInfoCard
import org.uniqstudio.mycity.ui.InfoPanel
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun CafeScreen(
    onClickBack: () -> Unit,
    cafeViewModel: CafeViewModel,
    windowSize: WindowSizeClass
) {
    val cafeUiState by cafeViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.coffee_shops,
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
                        CafeList(
                            CafeDataSource().loadCafes(),
                            cafeViewModel,
                            { isShowingList = !isShowingList }
                        )
                    } else {
                        InfoPanel(
                            image = cafeUiState.bannerResourceId,
                            title = cafeUiState.name,
                            description = cafeUiState.description,
                            subText1 = cafeUiState.location,
                            subText2 = cafeUiState.rating,
                        )
                    }
                }


                else -> {
                    CafeListAndInfo(
                        CafeDataSource().loadCafes(),
                        cafeViewModel,
                        {},
                        cafeUiState.bannerResourceId,
                        cafeUiState.name,
                        cafeUiState.description,
                        cafeUiState.location,
                        cafeUiState.rating
                    )
                }
            }
        }
    }
}

@Composable
fun CafeList(
    cafes: List<Cafe>,
    viewModel: CafeViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(cafes) { cafe ->
            CafeCard(
                cafe = cafe,
                onClick = {
                    viewModel.updateInfoPanel(
                        bannerResourceId = cafe.bannerResourceId,
                        name = cafe.name,
                        description = cafe.description,
                        location = cafe.location,
                        rating = cafe.rating
                    )
                    onClick()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun CafeListAndInfo(
    cafes: List<Cafe>,
    viewModel: CafeViewModel,
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
        CafeList(
            cafes = cafes,
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
fun CafeCard(
    cafe: Cafe,
    onClick: () -> Unit
){
    HorizontalImageInfoCard(
        image = cafe.imageResourceId,
        title = cafe.name,
        description = cafe.description,
        subText1 = cafe.location,
        subText2 = cafe.rating,
        onClick = onClick,
    )
}