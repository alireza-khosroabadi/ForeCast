package com.alireza.eliqtask.domian.model.weather

data class Hourly(
    var timeUnit          : String= "",
    var temperature2mUnit : String= "",
    var weatherCodeUnit   : String= "",
    var data              : List<HourlyData> = listOf()
)

data class HourlyData(
    var time          : String,
    var temperature2m : Double,
    var weatherCode   : Int
)
