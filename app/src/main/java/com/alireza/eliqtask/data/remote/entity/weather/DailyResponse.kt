package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class DailyResponse(
     @Json(name="time"               ) var time             : List<String> = listOf(),
     @Json(name="weathercode"        ) var weathercode      : List<Int>    = listOf(),
     @Json(name="temperature_2m_max" ) var temperature_2m_max : List<Double> = listOf(),
     @Json(name="temperature_2m_min" ) var temperature_2m_min : List<Double> = listOf(),
     @Json(name="windspeed_10m_max"  ) var windspeed10mMax  : List<Double> = listOf()
)
