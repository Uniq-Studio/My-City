package org.uniqstudio.mycity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.ui.ImageInlineText
import org.uniqstudio.mycity.ui.ImageTitleAndDescription
import org.uniqstudio.mycity.ui.TopBar

@Composable
fun AboutCreator(
    screenName: Int,
    onClickBack: () -> Unit,
    windowSize: WindowSizeClass
) {
    Scaffold(
        topBar = {
            TopBar(
                image = R.drawable.logo_uniq,
                text = screenName,
                goBack = true,
                onClickBack = {onClickBack()}
            )
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ) {
            when (windowSize.widthSizeClass) {
                WindowWidthSizeClass.Compact -> {
                    AboutCreatorPortrait()
                }
             else ->{
                AboutCreatorLandscape()
             }
            }
        }
    }
}

@Composable
fun AboutCreatorPortrait() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 150.dp)
                .fillMaxSize()
        ) {
            ImageTitleAndDescription(
                image = R.drawable.user_profile,
                title = R.string.about_creator_name,
                description = R.string.about_creator_subtitle,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            CreatorSocials()
        }
    }
}

@Composable
fun AboutCreatorLandscape() {
    Row(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).fillMaxSize()
        ){
            ImageTitleAndDescription(
                image = R.drawable.user_profile,
                title = R.string.about_creator_name,
                description = R.string.about_creator_subtitle,
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f).fillMaxSize()){
            CreatorSocials()
        }
    }
}


@Composable
fun CreatorSocials() {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp),) {
        ImageInlineText(
            image = R.drawable.broken_phone,
            text = R.string.about_creator_number
        )
        ImageInlineText(
            image = R.drawable.broken_mail,
            text = R.string.about_creator_email
        )
        ImageInlineText(
            image = R.drawable.broken_share,
            text = R.string.about_creator_social
        )
    }
}

@Preview
@Composable
fun AboutCreatorPortraitPreview() {
    AboutCreatorPortrait()
}

@Preview
@Composable
fun AboutCreatorLandscapePreview() {
    AboutCreatorLandscape()
}