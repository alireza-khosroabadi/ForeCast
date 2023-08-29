package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class HourlyResponse(
    @field:Json(name="time"           ) var time          : ArrayList<String> = arrayListOf(),
    @field:Json(name="temperature_2m" ) var temperature2m : ArrayList<Double> = arrayListOf(),
    @field:Json(name="weathercode"    ) var weathercode   : ArrayList<Int>    = arrayListOf()
)
