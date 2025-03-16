package org.uniqstudio.mycity.model.restaurant

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.uniqstudio.mycity.data.restaurant.RestaurantUiState

class RestaurantViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(RestaurantUiState())
    val uiState: StateFlow<RestaurantUiState> = _uiState.asStateFlow()

    fun updateInfoPanel (
        bannerResourceId: Int,
        name: Int,
        description: Int,
        location: Int,
        rating: Int
    ){
        _uiState.value = RestaurantUiState(
            bannerResourceId = bannerResourceId,
            name = name,
            description = description,
            location = location,
            rating = rating
        )

    }
}