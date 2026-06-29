package com.example.trail.presentation.screens.location

import com.example.trail.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor() : BaseViewModel<LocationState>(LocationState()) {

    fun onSearchQueryChange(newQuery: String) {
        _uiState.value = _uiState.value.copy(searchQuery = newQuery)
    }

    fun onCitySelect(city: String) {
        _uiState.value = _uiState.value.copy(selectedCity = city)
    }
}
