package com.alireza.eliqtask.data.remote.entity.weather

import com.squareup.moshi.Json

data class WeatherResponse(
     @Json(name ="latitude"              ) var latitude             : Double?         = null,
     @Json(name ="longitude"             ) var longitude            : Double?         = null,
     @Json(name ="generationtime_ms"     ) var generationTimeMs     : Double?         = null,
     @Json(name ="utc_offset_seconds"    ) var utcOffsetSeconds     : Int?            = null,
     @Json(name ="timezone"              ) var timezone             : String?         = null,
     @Json(name ="timezone_abbreviation" ) var timezoneAbbreviation : String?         = null,
     @Json(name ="elevation"             ) var elevation            : Int?            = null,
     @Json(name ="current_weather"       ) var currentWeather       : CurrentWeatherResponse? = CurrentWeatherResponse(),
     @Json(name ="hourly_units"          ) var hourlyUnits          : HourlyUnitsResponse?    = HourlyUnitsResponse(),
     @Json(name ="hourly"                ) var hourly               : HourlyResponse?         = HourlyResponse(),
     @Json(name ="daily_units"           ) var dailyUnits           : DailyUnitsResponse?     = DailyUnitsResponse(),
     @Json(name ="daily"                 ) var daily                : DailyResponse?          = DailyResponse()
)