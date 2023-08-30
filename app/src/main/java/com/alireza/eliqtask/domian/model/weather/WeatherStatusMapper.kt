package com.alireza.eliqtask.domian.model.weather

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus

fun weatherStatusFromInt(code: Int?): WeatherStatus = when (code) {
    0 -> WeatherStatus.Clear
    1, 2, 3 -> WeatherStatus.PartlyCloudy
    45, 48 -> WeatherStatus.Fog
    51, 53, 55 -> WeatherStatus.Drizzle
    56, 57 -> WeatherStatus.FreezingDrizzle
    61, 63, 65 -> WeatherStatus.Rain
    66, 67 -> WeatherStatus.FreezingRain
    71, 73, 75 -> WeatherStatus.SnowFall
    77 -> WeatherStatus.Snow
    80, 81, 82 -> WeatherStatus.RainShowers
    85, 86 -> WeatherStatus.SnowShowers
    95 -> WeatherStatus.Thunderstorm
    96, 99 -> WeatherStatus.Thunderstorm
    else -> WeatherStatus.Clear
}