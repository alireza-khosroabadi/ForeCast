package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class HourlyUnitsResponse(
     @Json(name="time"             ) var time            : String? = null,
     @Json(name="temperature_2m"   ) var temperature2m   : String? = null,
     @Json(name="weathercode"      ) var weathercode     : String? = null,
     @Json(name="windspeed_10m"    ) var windspeed10m    : String? = null,
     @Json(name="precipitation_probability"             ) var precipitationProbability            : String? = null
)
