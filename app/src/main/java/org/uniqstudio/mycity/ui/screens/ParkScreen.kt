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
import org.uniqstudio.mycity.data.parks.ParkDataSource
import org.uniqstudio.mycity.model.parks.Park
import org.uniqstudio.mycity.model.parks.ParkViewModel
import org.uniqstudio.mycity.ui.HorizontalImageInfoCard
import org.uniqstudio.mycity.ui.InfoPanel
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun ParkScreen(
    onClickBack: () -> Unit,
    parkViewModel: ParkViewModel,
    windowSize: WindowSizeClass
) {
    val parkUiState by parkViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.parks,
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
                        ParkList(
                            ParkDataSource().loadPark(),
                            parkViewModel,
                            { isShowingList = !isShowingList }
                        )
                    } else {
                        InfoPanel(
                            image = parkUiState.bannerResourceId,
                            title = parkUiState.name,
                            description = parkUiState.description,
                            subText1 = parkUiState.location,
                            subText2 = parkUiState.rating,
                        )
                    }
                }


                else -> {
                    ParkListAndInfo(
                        ParkDataSource().loadPark(),
                        parkViewModel,
                        {},
                        parkUiState.bannerResourceId,
                        parkUiState.name,
                        parkUiState.description,
                        parkUiState.location,
                        parkUiState.rating
                    )
                }
            }
        }
    }
}

@Composable
fun ParkList(
    park: List<Park>,
    viewModel: ParkViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(park) { park ->
            ParkCard(
                park = park,
                onClick = {
                    viewModel.updateInfoPanel(
                        bannerResourceId = park.bannerResourceId,
                        name = park.name,
                        description = park.description,
                        location = park.location,
                        rating = park.rating
                    )
                    onClick()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun ParkListAndInfo(
    park: List<Park>,
    viewModel: ParkViewModel,
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
        ParkList(
            park = park,
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
fun ParkCard(
    park: Park,
    onClick: () -> Unit
){
    HorizontalImageInfoCard(
        image = park.imageResourceId,
        title = park.name,
        description = park.description,
        subText1 = park.location,
        subText2 = park.rating,
        onClick = onClick,
    )
}