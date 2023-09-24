package com.alireza.eliqtask.presentation.forecast.hourlyWeather.sampleData

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus
import com.alireza.eliqtask.domian.model.weather.Hourly
import com.alireza.eliqtask.domian.model.weather.HourlyData

class HourlyWeatherProvider : PreviewParameterProvider<Hourly> {
    override val values: Sequence<Hourly>
        get() = listOf(
            Hourly(
                timeUnit = "22-10-2023",
                data = listOf(
                    HourlyData(
                        time = "00:00",
                        temperature2m = "23 C",
                        weatherCode = WeatherStatus.Rain,
                        precipitationProbability = "20%"
                    ),
                    HourlyData(
                        time = "01:00",
                        temperature2m = "20 C",
                        weatherCode = WeatherStatus.PartlyCloudy,
                        precipitationProbability = "20%"
                    )
                )
            )
        ).asSequence()
}