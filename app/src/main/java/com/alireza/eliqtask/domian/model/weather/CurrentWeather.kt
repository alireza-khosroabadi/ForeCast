package com.alireza.eliqtask.domian.model.weather

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus
import java.util.Date

data class CurrentWeather(
    var temperature   : String? = null,
    var windSpeed     : String? = null,
    var windDirection : Int?    = null,
    var weatherCode   : WeatherStatus?    = null,
    var isDay         : Int?    = null,
    var time          : String? = null,
    var location      : String? =null
)