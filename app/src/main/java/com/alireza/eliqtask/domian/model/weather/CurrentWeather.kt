package com.alireza.eliqtask.domian.model.weather

data class CurrentWeather(
    var temperature   : Double? = null,
    var windSpeed     : Double? = null,
    var windDirection : Int?    = null,
    var weatherCode   : Int?    = null,
    var isDay         : Int?    = null,
    var time          : String? = null
)