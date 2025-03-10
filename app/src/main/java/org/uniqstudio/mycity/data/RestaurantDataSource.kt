package org.uniqstudio.mycity.data

import org.uniqstudio.mycity.R
import org.uniqstudio.mycity.model.Restaurant

class RestaurantDataSource {
    fun loadRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(
                imageResourceId = R.drawable.ic_launcher_foreground,
                bannerResourceId = R.drawable.ic_launcher_background,
                name = R.string.kg_name,
                description = R.string.kg_description,
                location = R.string.kg_location,
                rating = R.string.rating_one
            ),
            Restaurant(
                imageResourceId = R.drawable.ic_launcher_foreground,
                bannerResourceId = R.drawable.ic_launcher_background,
                name = R.string.ccr_name,
                description = R.string.ccr_description,
                location = R.string.ccr_location,
                rating = R.string.rating_two
            ),
            Restaurant(
                imageResourceId = R.drawable.ic_launcher_foreground,
                bannerResourceId = R.drawable.ic_launcher_background,
                name = R.string.tlb_name,
                description = R.string.tlb_description,
                location = R.string.tlb_location,
                rating = R.string.rating_two
            ),
            Restaurant(
                imageResourceId = R.drawable.ic_launcher_foreground,
                bannerResourceId = R.drawable.ic_launcher_background,
                name = R.string.tal_name,
                description = R.string.tal_description,
                location = R.string.tal_location,
                rating = R.string.rating_two
            ),
        )
    }
}