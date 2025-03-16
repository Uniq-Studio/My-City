package org.uniqstudio.mycity.ui.screens

import android.R.attr.description
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
import androidx.lifecycle.ViewModel
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.data.cafes.CafeDataSource
import org.uniqstudio.mycity.data.kid_friendly.KidFriendlyDataSource
import org.uniqstudio.mycity.model.cafes.Cafe
import org.uniqstudio.mycity.model.cafes.CafeViewModel
import org.uniqstudio.mycity.model.kid_friendly.KidFriendly
import org.uniqstudio.mycity.model.kid_friendly.KidFriendlyViewModel
import org.uniqstudio.mycity.ui.HorizontalImageInfoCard
import org.uniqstudio.mycity.ui.InfoPanel
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun KidFriendlyScreen(
    onClickBack: () -> Unit,
    kidFriendlyViewModel: KidFriendlyViewModel,
    windowSize: WindowSizeClass
) {
    val kidFriendlyUiState by kidFriendlyViewModel.uiState.collectAsState()

    var isShowingList by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = R.string.kid_friendly_places,
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
                        KidFriendlyList(
                            KidFriendlyDataSource().loadKidFriendly(),
                            kidFriendlyViewModel,
                            { isShowingList = !isShowingList }
                        )
                    } else {
                        InfoPanel(
                            image = kidFriendlyUiState.bannerResourceId,
                            title = kidFriendlyUiState.name,
                            description = kidFriendlyUiState.description,
                            subText1 = kidFriendlyUiState.location,
                            subText2 = kidFriendlyUiState.rating,
                        )
                    }
                }


                else -> {
                    KidFriendlyListAndInfo(
                        KidFriendlyDataSource().loadKidFriendly(),
                        kidFriendlyViewModel,
                        {},
                        kidFriendlyUiState.bannerResourceId,
                        kidFriendlyUiState.name,
                        kidFriendlyUiState.description,
                        kidFriendlyUiState.location,
                        kidFriendlyUiState.rating
                    )
                }
            }
        }
    }
}

@Composable
fun KidFriendlyList(
    kidFriendly: List<KidFriendly>,
    viewModel: KidFriendlyViewModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(kidFriendly) { kidFriendly ->
            KidFriendlyCard(
                kidFriendly = kidFriendly,
                onClick = {
                    viewModel.updateInfoPanel(
                        bannerResourceId = kidFriendly.bannerResourceId,
                        name = kidFriendly.name,
                        description = kidFriendly.description,
                        location = kidFriendly.location,
                        rating = kidFriendly.rating
                    )
                    onClick()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Composable
fun KidFriendlyListAndInfo(
    kidFriendly: List<KidFriendly>,
    viewModel: KidFriendlyViewModel,
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
        KidFriendlyList(
            kidFriendly = kidFriendly,
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
fun KidFriendlyCard(
    kidFriendly: KidFriendly,
    onClick: () -> Unit
){
    HorizontalImageInfoCard(
        image = kidFriendly.imageResourceId,
        title = kidFriendly.name,
        description = kidFriendly.description,
        subText1 = kidFriendly.location,
        subText2 = kidFriendly.rating,
        onClick = onClick,
    )
}