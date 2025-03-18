package org.uniqstudio.mycity.data.parks

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.parks.Park

class ParkDataSource {
    fun loadPark(): List<Park> {
        return listOf(
            Park(
                imageResourceId = R.drawable.kg_photo,
                bannerResourceId = R.drawable.kg_banner,
                name = R.string.kg_name,
                description = R.string.kg_description,
                location = R.string.kg_location,
                rating = R.string.rating_one
            ),
            Park(
                imageResourceId = R.drawable.ccr_photo,
                bannerResourceId = R.drawable.ccr_banner,
                name = R.string.ccr_name,
                description = R.string.ccr_description,
                location = R.string.ccr_location,
                rating = R.string.rating_two
            ),
            Park(
                imageResourceId = R.drawable.tlb_photo,
                bannerResourceId = R.drawable.tlb_banner,
                name = R.string.tlb_name,
                description = R.string.tlb_description,
                location = R.string.tlb_location,
                rating = R.string.rating_two
            ),
            Park(
                imageResourceId = R.drawable.tal_photo,
                bannerResourceId = R.drawable.tal_banner,
                name = R.string.tal_name,
                description = R.string.tal_description,
                location = R.string.tal_location,
                rating = R.string.rating_two
            ),
        )
    }
}