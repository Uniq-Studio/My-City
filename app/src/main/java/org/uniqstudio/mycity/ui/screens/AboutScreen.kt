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
import org.uniqstudio.mycity.ui.TitleAndParagraph
import org.uniqstudio.mycity.ui.TopBar
import org.uniqstudio.mycity.ui.WideButtonBar

@Composable
fun AboutScreen(
    screenName: Int,
    onClickBack: () -> Unit,
    onClickCreator: () -> Unit,
    windowSize: WindowSizeClass
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopBar(
                    image = R.drawable.logo_uniq,
                    text = screenName,
                    goBack = true,
                    onClickBack = { onClickBack() }
                )
            }
        ) { innerpadding ->
            Column(
                modifier = Modifier.padding(innerpadding)
            ) {
                when (windowSize.widthSizeClass) {
                    WindowWidthSizeClass.Compact -> {
                        AboutPortrait()
                    }

                    else -> {
                        AboutLandscape()
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            WideButtonBar(
                text = R.string.about_creator,
                bold = true,
                onClick = onClickCreator,
            )
        }
    }
}



@Composable
fun AboutPortrait(){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        TitleAndParagraph(
            title = R.string.about_title,
            text = R.string.about_text,
            bold = true
        )
        TitleAndParagraph(
            title = R.string.about_resources,
            text = R.string.about_resources_text,
            bold = true
        )
        TitleAndParagraph(
            title = R.string.about_disclaimer,
            text = R.string.about_disclaimer_text,
            bold = true
        )
    }
}

@Composable
fun AboutLandscape(){
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(15.dp, bottom = 75.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        TitleAndParagraph(
            title = R.string.about_title,
            text = R.string.about_text,
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = R.string.about_resources,
            text = R.string.about_resources_text,
            bold = true,
            modifier = Modifier.weight(1f)
        )
        TitleAndParagraph(
            title = R.string.about_disclaimer,
            text = R.string.about_disclaimer_text,
            bold = true,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun AboutPortraitPreview(){
    AboutPortrait()
}
@Preview
@Composable
fun AboutLandscapePreview(){
    AboutLandscape()
}

