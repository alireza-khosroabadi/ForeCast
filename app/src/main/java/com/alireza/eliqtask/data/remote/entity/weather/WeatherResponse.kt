package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class WeatherResponse(
    @field:Json(name ="latitude"              ) var latitude             : Double?         = null,
    @field:Json(name ="longitude"             ) var longitude            : Double?         = null,
    @field:Json(name ="generationtime_ms"     ) var generationtimeMs     : Double?         = null,
    @field:Json(name ="utc_offset_seconds"    ) var utcOffsetSeconds     : Int?            = null,
    @field:Json(name ="timezone"              ) var timezone             : String?         = null,
    @field:Json(name ="timezone_abbreviation" ) var timezoneAbbreviation : String?         = null,
    @field:Json(name ="elevation"             ) var elevation            : Int?            = null,
    @field:Json(name ="current_weather"       ) var currentWeather       : CurrentWeatherResponse? = CurrentWeatherResponse(),
    @field:Json(name ="hourly_units"          ) var hourlyUnits          : HourlyUnitsResponse?    = HourlyUnitsResponse(),
    @field:Json(name ="hourly"                ) var hourly               : HourlyResponse?         = HourlyResponse(),
    @field:Json(name ="daily_units"           ) var dailyUnits           : DailyUnitsResponse?     = DailyUnitsResponse(),
    @field:Json(name ="daily"                 ) var daily                : DailyResponse?          = DailyResponse()
)