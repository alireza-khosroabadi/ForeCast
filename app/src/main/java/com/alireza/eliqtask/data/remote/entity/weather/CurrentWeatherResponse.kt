package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class CurrentWeatherResponse(
    @field:Json(name="temperature"   ) var temperature   : Double? = null,
    @field:Json(name="windspeed"     ) var windspeed     : Double? = null,
    @field:Json(name="winddirection" ) var winddirection : Int?    = null,
    @field:Json(name="weathercode"   ) var weathercode   : Int?    = null,
    @field:Json(name="is_day"        ) var isDay         : Int?    = null,
    @field:Json(name="time"          ) var time          : String? = null
)