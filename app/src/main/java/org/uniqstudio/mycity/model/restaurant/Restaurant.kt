package org.uniqstudio.mycity.model.restaurant

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant(
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val bannerResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val location: Int,
    @StringRes val rating: Int

)