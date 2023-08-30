package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json
import java.util.Date

data class HourlyResponse(
     @Json(name="time"             ) var time            : List<Date> = listOf(),
     @Json(name="temperature_2m"   ) var temperature_2m  : List<Double> = listOf(),
     @Json(name="weathercode"      ) var weathercode     : List<Int>    = listOf(),
     @Json(name="precipitation_probability") var precipitationProbability    : List<Double> = listOf()
     )
