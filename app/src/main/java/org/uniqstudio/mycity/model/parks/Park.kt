package org.uniqstudio.mycity.model.parks

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Park(
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val bannerResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val location: Int,
    @StringRes val rating: Int

)