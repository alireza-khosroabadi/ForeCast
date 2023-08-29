package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class HourlyResponse(
     @Json(name="time"           ) var time          : List<String> = listOf(),
     @Json(name="temperature_2m" ) var temperature_2m : List<Double> = listOf(),
     @Json(name="weathercode"    ) var weathercode   : List<Int>    = listOf()
)
