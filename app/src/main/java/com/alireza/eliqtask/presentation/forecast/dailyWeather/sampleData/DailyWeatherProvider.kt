package com.alireza.eliqtask.presentation.forecast.dailyWeather.sampleData

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.alireza.eliqtask.base.constant.DEGREE_SYMBOL
import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus
import com.alireza.eliqtask.domian.model.weather.Daily
import com.alireza.eliqtask.domian.model.weather.DailyData

class DailyWeatherProvider : PreviewParameterProvider<Daily> {
    override val values: Sequence<Daily>
        get() = listOf(
            Daily(
                timeUnit = "", data = listOf(
                    DailyData(
                        time = "22-10-2023",
                        weatherCode = WeatherStatus.Fog,
                        temperature = "14$DEGREE_SYMBOL",
                        windSpeed10mMax = "20/km"
                    ),
                    DailyData(
                        time = "23-10-2023",
                        weatherCode = WeatherStatus.Rain,
                        temperature = "10$DEGREE_SYMBOL",
                        windSpeed10mMax = "25/km"
                    )
                )
            )
        ).asSequence()
}