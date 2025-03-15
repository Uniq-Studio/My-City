package org.uniqstudio.mycity.ui


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.uniqstudio.mycity.R

@Composable
fun TopBar(
    @DrawableRes image: Int,
    @StringRes text: Int,
    goBack: Boolean,
    onClickBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(top = 20.dp)
    ) {
        //Back Button
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            if (goBack) {
                IconButton(
                    onClick = onClickBack,
                    modifier = Modifier.size(50.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.broken_arrow_left),
                        contentDescription = null,
                    )
                }
            }
        }

        //Text and Image
        Column() {
            Spacer(modifier = Modifier.weight(1f))
            Row() {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.size(5.dp))

                TextForUI(
                    text = text,
                    bold = true
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

        //Balance it out
        Box(
            modifier = Modifier
                .weight(1f)
        ) {}
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(image = R.drawable.logo_uniq, text = R.string.app_name, goBack = true, onClickBack = {})
}


@Composable
fun TitleText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        style = MaterialTheme.typography.headlineLarge,
        fontSize = 45.sp,
    )
}

@Preview
@Composable
fun TitleTextPreview() {
    TitleText(text = R.string.app_name)
}


@Composable
fun BoldTitleText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp,
    )
}

@Preview
@Composable
fun BoldTitleTextPreview() {
    BoldTitleText(text = R.string.app_name)
}


@Composable
fun SmallTextTitle(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        style = MaterialTheme.typography.bodySmall,
        fontSize = 20.sp,
    )
}

@Preview
@Composable
fun SmallTextTitlePreview() {
    SmallTextTitle(text = R.string.app_name)
}


@Composable
fun DescriptionText(@StringRes text: Int) {
    Text(
        text = stringResource(text),
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 15.sp
    )
}

@Preview
@Composable
fun DescriptionTextPreview() {
    DescriptionText(text = R.string.app_name)
}


@Composable
fun TextForUI(@StringRes text: Int, bold: Boolean) {
    if (!bold) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp
        )
    } else {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun TextForUIPreview() {
    Column {
        TextForUI(text = R.string.app_name, bold = true)
        TextForUI(text = R.string.app_name, bold = false)
    }
}


@Composable
fun BlankSpaceFiller() {
    Spacer(modifier = Modifier.size(150.dp))
}

@Preview
@Composable
fun BlankSpaceFillerPreview() {
    BlankSpaceFiller()
}


@Composable
fun NextButton(onClickNext: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        //Next button
        IconButton(
            onClick = onClickNext,
            modifier = Modifier.size(150.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.broken_arrow_right),
                contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .size(150.dp)
            )
        }
    }
}

@Preview
@Composable
fun NextButtonPreview() {
    NextButton(onClickNext = {})
}


@Composable
fun WideButtonBar(@StringRes text: Int, bold: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        FilledTonalButton(
            onClick = onClick,
            shape = MaterialTheme.shapes.extraSmall,
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
        ) {
            TextForUI(text = text, bold = bold)
        }
    }
}

@Suppress("PreviewShouldNotBeCalledRecursively")
@Preview
@Composable
fun WideButtonBar() {
    Column {
        WideButtonBar(text = R.string.app_name, bold = true, onClick = {})
        Spacer(modifier = Modifier.size(5.dp))
        WideButtonBar(text = R.string.app_name, bold = false, onClick = {})
    }
}


@Composable
fun TripleButtonBar(
    @StringRes text1: Int,
    @StringRes text2: Int,
    @StringRes text3: Int,
    bold1: Boolean,
    bold2: Boolean,
    bold3: Boolean,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Column {
        Row {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                WideButtonBar(text = text1, bold = bold1, onClick = onClick1)
            }

            Spacer(modifier = Modifier.size(5.dp))

            Box(
                modifier = Modifier.weight(1f)
            ) {
                WideButtonBar(text = text2, bold = bold2, onClick = onClick2)

            }
        }

        Spacer(modifier = Modifier.size(5.dp))

        WideButtonBar(text = text3, bold = bold3, onClick = onClick3)
    }
}

@Preview
@Composable
fun TripleButtonBarPreview() {
    TripleButtonBar(
        text1 = R.string.app_name,
        text2 = R.string.app_name,
        text3 = R.string.app_name,
        bold1 = false,
        bold2 = false,
        bold3 = true,
        onClick1 = {},
        onClick2 = {},
        onClick3 = {}
    )
}


@Composable
fun SquareImageButton(
    @DrawableRes image: Int,
    @StringRes text: Int,
    bold: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledTonalButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            .size(150.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(text),
                modifier = modifier
                    .size(100.dp)
                    .padding(15.dp)
            )
            TextForUI(text = text, bold = bold)
        }
    }
}

@Preview
@Composable
fun SquareImageButtonPreview() {
    Row {
        SquareImageButton(
            image = R.drawable.broken_arrow_right,
            text = R.string.app_name,
            bold = true,
            onClick = {}
        )

        Spacer(modifier = Modifier.size(10.dp))

        SquareImageButton(
            image = R.drawable.broken_arrow_right,
            text = R.string.app_name,
            bold = false,
            onClick = {}
        )
    }
}


@Composable
fun HiddenDetailsBox(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    @StringRes description: Int
) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Row()
            {
                Spacer(modifier = Modifier.size(10.dp))

                TextForUI(title, true)

                Spacer(modifier = Modifier.weight(1f))

                Column(
                    modifier = Modifier
                        .height(40.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    TextForUI(
                        text = subtitle,
                        bold = false
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }

                Column(
                    modifier = Modifier
                        .height(40.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    if (description != 0) {
                        if (expanded) {
                            Icon(
                                Icons.Filled.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.clickable(onClick = { expanded = !expanded })
                            )
                        } else {
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.clickable(onClick = { expanded = !expanded })
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            if (expanded) {
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    TextForUI(
                        text = description,
                        bold = false
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun HiddenDetailsPreview() {
    HiddenDetailsBox(
        title = R.string.app_name,
        subtitle = R.string.app_name,
        description = R.string.app_name
    )
}


@Composable
fun HorizontalImageInfoCard(
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    @StringRes subText1: Int,
    @StringRes subText2: Int,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))

            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxSize()
            ) {

                Box(modifier = Modifier.weight(2f)) {
                    TextForUI(
                        text = title,
                        bold = true
                    )
                }

                Box(modifier = Modifier.weight(3f)) {
                    DescriptionText(text = description)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        DescriptionText(text = subText1)
                    }

                    Spacer(modifier = Modifier.size(5.dp))

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        DescriptionText(text = subText2)
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun HorizontalImageInfoCardPreview() {
    HorizontalImageInfoCard(
        image = R.drawable.ic_launcher_background,
        title = R.string.app_name,
        description = R.string.app_name,
        subText1 = R.string.app_name,
        subText2 = R.string.app_name
    )
}


@Composable
fun InfoPanel(
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    @StringRes subText1: Int,
    @StringRes subText2: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column() {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleText(text = title)

                Spacer(modifier = Modifier.size(10.dp))

                DescriptionText(text = description)
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row {
                Box(modifier = Modifier.weight(1f)) { DescriptionText(text = subText1) }
                Spacer(modifier = Modifier.size(10.dp))
                Box(modifier = Modifier.weight(1f)) { DescriptionText(text = subText2) }
            }
        }
    }
}

@Preview
@Composable
fun InfoPanelPreview() {
    InfoPanel(
        image = R.drawable.ic_launcher_background,
        title = R.string.app_name,
        description = R.string.app_name,
        subText1 = R.string.app_name,
        subText2 = R.string.app_name
    )
}