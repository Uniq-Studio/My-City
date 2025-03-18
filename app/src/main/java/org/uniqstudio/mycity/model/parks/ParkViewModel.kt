package org.uniqstudio.mycity.model.parks

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.uniqstudio.mycity.data.parks.ParkUiState

class ParkViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(ParkUiState())
    val uiState: StateFlow<ParkUiState> = _uiState.asStateFlow()

    fun updateInfoPanel (
        bannerResourceId: Int,
        name: Int,
        description: Int,
        location: Int,
        rating: Int
    ){
        _uiState.value = ParkUiState(
            bannerResourceId = bannerResourceId,
            name = name,
            description = description,
            location = location,
            rating = rating
        )

    }
}