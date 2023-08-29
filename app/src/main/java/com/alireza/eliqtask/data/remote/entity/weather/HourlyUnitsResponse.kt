package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class HourlyUnitsResponse(
    @field:Json(name="time"           ) var time          : String? = null,
    @field:Json(name="temperature_2m" ) var temperature2m : String? = null,
    @field:Json(name="weathercode"    ) var weathercode   : String? = null
)
