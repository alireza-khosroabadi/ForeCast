package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class DailyResponse(
    @field:Json(name="time"               ) var time             : ArrayList<String> = arrayListOf(),
    @field:Json(name="weathercode"        ) var weathercode      : ArrayList<Int>    = arrayListOf(),
    @field:Json(name="temperature_2m_max" ) var temperature2mMax : ArrayList<Double> = arrayListOf(),
    @field:Json(name="temperature_2m_min" ) var temperature2mMin : ArrayList<Double> = arrayListOf()

)
