package org.uniqstudio.mycity.data.datasource

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.Place

class CafeDataSource {
    fun loadCafes(): List<Place> {
        return listOf(
            Place(
                imageResourceId = R.drawable.sc_photo,
                bannerResourceId = R.drawable.sc_banner,
                name = R.string.sc_name,
                description = R.string.sc_description,
                location = R.string.sc_location,
                rating = R.string.rating_one
            ),
            Place(
                imageResourceId = R.drawable.tgc_photo,
                bannerResourceId = R.drawable.tgc_banner,
                name = R.string.tgc_name,
                description = R.string.tgc_description,
                location = R.string.tgc_location,
                rating = R.string.rating_two
            ),
            Place(
                imageResourceId = R.drawable.kc_photo,
                bannerResourceId = R.drawable.kc_banner,
                name = R.string.kc_name,
                description = R.string.kc_description,
                location = R.string.kc_location,
                rating = R.string.rating_two
            ),
            Place(
                imageResourceId = R.drawable.oc_photo,
                bannerResourceId = R.drawable.oc_banner,
                name = R.string.oc_name,
                description = R.string.oc_description,
                location = R.string.oc_location,
                rating = R.string.rating_one
            ),
        )
    }
}