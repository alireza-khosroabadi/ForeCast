package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class DailyUnitsResponse(
    @field:Json(name="time"               ) var time             : String? = null,
    @field:Json(name="weathercode"        ) var weathercode      : String? = null,
    @field:Json(name="temperature_2m_max" ) var temperature2mMax : String? = null,
    @field:Json(name="temperature_2m_min" ) var temperature2mMin : String? = null
)
