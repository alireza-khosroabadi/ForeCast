package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json
import java.util.Date

data class HourlyResponse(
     @Json(name="time"             ) var time            : List<Date> = listOf(),
     @Json(name="temperature_2m"   ) var temperature_2m  : List<Double> = listOf(),
     @Json(name="weathercode"      ) var weathercode     : List<Int>    = listOf(),
     @Json(name="rain"             ) var rain            : List<Double> = listOf(),
     @Json(name="surface_pressure" ) var surfacePressure : List<Double> = listOf(),
     @Json(name="windspeed_10m"    ) var windspeed10m    : List<Double> = listOf()
     )
