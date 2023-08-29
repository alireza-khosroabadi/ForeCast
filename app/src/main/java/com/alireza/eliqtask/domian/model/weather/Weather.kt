package com.alireza.eliqtask.domian.model.weather

data class Weather(
    var time                 : Double?         = null,
    var utcOffsetSeconds     : Int?            = null,
    var currentWeather       : CurrentWeather? = CurrentWeather(),
    var hourly               : Hourly,
    var daily                : Daily
)
