package org.uniqstudio.mycity.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.ui.BlankSpaceFiller
import org.uniqstudio.mycity.ui.BoldTitleText
import org.uniqstudio.mycity.ui.NextButton
import org.uniqstudio.mycity.ui.SmallTextTitle
import org.uniqstudio.mycity.ui.TitleText

@Composable
fun WelcomeScreen(
    windowSize: WindowSizeClass,
    onClickNext: () -> Unit
){
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            WelcomeScreenPortrait(onClickNext)
        }
        else -> {
            WelcomeScreenLandscape(onClickNext)
        }
    }
}


@Composable
fun WelcomeScreenPortrait(
    onClickNext: () -> Unit
){
    Column(
    ){
        TitleText(R.string.welcome_to)
        BoldTitleText(R.string.my_city)
        SmallTextTitle(R.string.glasgow)

        BlankSpaceFiller()

        NextButton(
            onClickNext = onClickNext
        )
    }
}

@Composable
fun WelcomeScreenLandscape(
    onClickNext: () -> Unit
) {
    Column {
        TitleText(R.string.welcome_to)
        BoldTitleText(R.string.my_city)
        SmallTextTitle(R.string.glasgow)

        NextButton(
            onClickNext = onClickNext
        )
    }
}

@Preview
@Composable
fun WelcomeScreenPortraitPreview(){
    WelcomeScreenPortrait({})
}

@Preview
@Composable
fun WelcomeScreenLandscapePreview(){
    WelcomeScreenLandscape({})
}