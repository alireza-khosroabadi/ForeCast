package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json
import java.util.Date

data class CurrentWeatherResponse(
     @Json(name="temperature"   ) var temperature   : Double? = null,
     @Json(name="windspeed"     ) var windspeed     : Double? = null,
     @Json(name="winddirection" ) var winddirection : Int?    = null,
     @Json(name="weathercode"   ) var weathercode   : Int?    = null,
     @Json(name="is_day"        ) var isDay         : Int?    = null,
     @Json(name="time"          ) var time          : Date? = null
)