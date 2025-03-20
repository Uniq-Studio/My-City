package org.uniqstudio.mycity.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.uniqstudio.mycity.data.InfoPanelUiState

class PlaceViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(InfoPanelUiState())
    val uiState: StateFlow<InfoPanelUiState> = _uiState.asStateFlow()

    fun updateInfoPanel (
        bannerResourceId: Int,
        name: Int,
        description: Int,
        location: Int,
        rating: Int
    ){
        _uiState.value = InfoPanelUiState(
            bannerResourceId = bannerResourceId,
            name = name,
            description = description,
            location = location,
            rating = rating
        )

    }
}