package com.alireza.eliqtask.domian.model.weather

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus

data class Daily(
    var timeUnit             : String="",
    var data                 : List<DailyData> = listOf()
)

data class DailyData(
    var time: String,
    var weatherCode: WeatherStatus,
    var temperature: String,
    var windSpeed10mMax  : String,
)