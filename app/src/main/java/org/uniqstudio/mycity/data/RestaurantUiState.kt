package org.uniqstudio.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.uniqstudio.mycity.R

data class RestaurantUiState (
    @DrawableRes val bannerResourceId: Int = R.drawable.kg_banner,
    @StringRes val name: Int = R.string.kg_name,
    @StringRes val description: Int = R.string.kg_description,
    @StringRes val location: Int = R.string.kg_location,
    @StringRes val rating: Int = R.string.rating_one

)