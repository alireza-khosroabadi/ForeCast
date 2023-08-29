package com.alireza.eliqtask.presentation

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.domian.model.weather.Weather

sealed class WeatherViewState {
    data object Loading : WeatherViewState()
    data class ErrorData(val error: ErrorModel): WeatherViewState()
    data class WeatherData(val uiPattern: UiPattern, val weather: Weather) : WeatherViewState()


}
