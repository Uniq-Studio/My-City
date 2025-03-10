package org.uniqstudio.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.uniqstudio.mycity.R

data class RestaurantUiState (
    @DrawableRes val bannerResourceId: Int = R.drawable.ic_launcher_background,
    @StringRes val name: Int = R.string.app_name,
    @StringRes val description: Int = R.string.app_name,
    @StringRes val location: Int = R.string.app_name,
    @StringRes val rating: Int = R.string.app_name

)