package com.alireza.eliqtask.presentation.forecast.currentWeather.sampleData

import android.health.connect.datatypes.units.Temperature
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.alireza.eliqtask.base.constant.DEGREE_SYMBOL
import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus
import com.alireza.eliqtask.domian.model.weather.CurrentWeather

class CurrentWeatherProvider : PreviewParameterProvider<CurrentWeather> {
    override val values: Sequence<CurrentWeather>
        get() = listOf(
            CurrentWeather(
                temperature = "15$DEGREE_SYMBOL",
                windSpeed = "10km",
                windDirection = 135,
                weatherCode = WeatherStatus.Rain,
                isDay = 0,
                time = "16:00",
                location = "Tehran"
            )
        ).asSequence()
}