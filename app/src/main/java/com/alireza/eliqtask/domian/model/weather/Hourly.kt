package com.alireza.eliqtask.domian.model.weather

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus

data class Hourly(
    var timeUnit          : String= "",
    var data              : List<HourlyData> = listOf()
)

data class HourlyData(
    var time            : String,
    var temperature2m   : String,
    var weatherCode     : WeatherStatus,
    var precipitationProbability            : String
){
    var isDay = 0
}
