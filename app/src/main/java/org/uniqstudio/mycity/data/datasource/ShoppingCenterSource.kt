package org.uniqstudio.mycity.data.datasource

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.Place

class ShoppingCenterSource {
    fun loadShops(): List<Place> {
        return listOf(
            Place(
                imageResourceId = R.drawable.sec_photo,
                bannerResourceId = R.drawable.sec_banner,
                name = R.string.sec_name,
                description = R.string.sec_description,
                location = R.string.sec_location,
                rating = R.string.rating_three
            ),
            Place(
                imageResourceId = R.drawable.bg_photo,
                bannerResourceId = R.drawable.bg_banner,
                name = R.string.bg_name,
                description = R.string.bg_description,
                location = R.string.bg_location,
                rating = R.string.rating_three
            ),
            Place(
                imageResourceId = R.drawable.ps_photo,
                bannerResourceId = R.drawable.ps_banner,
                name = R.string.ps_name,
                description = R.string.ps_description,
                location = R.string.ps_location,
                rating = R.string.rating_three
            ),
            Place(
                imageResourceId = R.drawable.fsc_photo,
                bannerResourceId = R.drawable.fsc_banner,
                name = R.string.fsc_name,
                description = R.string.fsc_description,
                location = R.string.bp_location,
                rating = R.string.rating_three
            ),
        )
    }
}