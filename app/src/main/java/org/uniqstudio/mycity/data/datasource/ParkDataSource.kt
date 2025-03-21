package org.uniqstudio.mycity.data.datasource

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.Place

class ParkDataSource {
    fun loadPark(): List<Place> {
        return listOf(
            Place(
                imageResourceId = R.drawable.qp_photo,
                bannerResourceId = R.drawable.qp_banner,
                name = R.string.qp_name,
                description = R.string.qp_description,
                location = R.string.qp_location,
                rating = R.string.rating_free
            ),
            Place(
                imageResourceId = R.drawable.kp_photo,
                bannerResourceId = R.drawable.kp_banner,
                name = R.string.kp_name,
                description = R.string.kp_description,
                location = R.string.kp_location,
                rating = R.string.rating_free
            ),
            Place(
                imageResourceId = R.drawable.pcp_photo,
                bannerResourceId = R.drawable.pcp_banner,
                name = R.string.pcp_name,
                description = R.string.pcp_description,
                location = R.string.pcp_location,
                rating = R.string.rating_free
            ),
            Place(
                imageResourceId = R.drawable.bp_photo,
                bannerResourceId = R.drawable.bp_banner,
                name = R.string.bp_name,
                description = R.string.bp_description,
                location = R.string.bp_location,
                rating = R.string.rating_free
            ),
        )
    }
}