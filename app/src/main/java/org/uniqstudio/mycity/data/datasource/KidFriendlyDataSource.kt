package org.uniqstudio.mycity.data.datasource

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.Place

class KidFriendlyDataSource {
    fun loadKidFriendly(): List<Place> {
        return listOf(
            Place(
                imageResourceId = R.drawable.cw_photo,
                bannerResourceId = R.drawable.cw_banner,
                name = R.string.cw_name,
                description = R.string.cw_description,
                location = R.string.cw_location,
                rating = R.string.rating_free
            ),
            Place(
                imageResourceId = R.drawable.tp_photo,
                bannerResourceId = R.drawable.tp_banner,
                name = R.string.tp_name,
                description = R.string.tp_description,
                location = R.string.tp_location,
                rating = R.string.rating_free
            ),
            Place(
                imageResourceId = R.drawable.wwsp_photo,
                bannerResourceId = R.drawable.wwsp_banner,
                name = R.string.wwsp_name,
                description = R.string.wwsp_description,
                location = R.string.wwsp_location,
                rating = R.string.rating_one
            ),
            Place(
                imageResourceId = R.drawable.mp_photo,
                bannerResourceId = R.drawable.mp_banner,
                name = R.string.mp_name,
                description = R.string.mp_description,
                location = R.string.mp_location,
                rating = R.string.rating_free
            ),
        )
    }
}