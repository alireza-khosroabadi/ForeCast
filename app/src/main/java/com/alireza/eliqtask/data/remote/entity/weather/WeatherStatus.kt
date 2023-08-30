package com.alireza.eliqtask.data.remote.entity.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alireza.eliqtask.R

enum class WeatherStatus(@DrawableRes var iconDay: Int,@DrawableRes var iconNight: Int, @StringRes var title: Int) {
    Clear(R.drawable.fluent_weather_sunny_24_regular,R.drawable.fluent_weather_moon_24_regular, R.string.Clear ),
    PartlyCloudy(R.drawable.fluent_weather_partly_cloudy_day_24_regular,R.drawable.fluent_weather_partly_cloudy_night_24_regular, R.string.partly_cloudy ),
    Fog(R.drawable.fluent_weather_partly_cloudy_day_24_regular,R.drawable.fluent_weather_partly_cloudy_night_24_regular, R.string.fog ),
    Drizzle(R.drawable.fluent_weather_sunny_24_regular,R.drawable.fluent_weather_moon_24_regular, R.string.drizzle ),
    Freezing(R.drawable.fluent_weather_snowflake_24_regular,R.drawable.fluent_weather_snowflake_24_regular, R.string.freezing  ),
    FreezingDrizzle(R.drawable.fluent_weather_snowflake_24_regular,R.drawable.fluent_weather_snowflake_24_regular, R.string.freezing_drizzle  ),
    FreezingRain(R.drawable.fluent_weather_sunny_24_regular,R.drawable.fluent_weather_moon_24_regular, R.string.freezing_rain ),
    Rain(R.drawable.fluent_weather_rain_24_regular,R.drawable.fluent_weather_rain_24_regular, R.string.rain ),
    SnowFall(R.drawable.fluent_weather_snow_24_regular,R.drawable.fluent_weather_snow_24_regular, R.string.snow_fall ),
    Snow(R.drawable.mdi_weather_snowy_heavy,R.drawable.mdi_weather_snowy_heavy, R.string.snow ),
    RainShowers(R.drawable.fluent_weather_rain_showers_day_24_regular,R.drawable.fluent_weather_rain_showers_night_24_regular, R.string.rain_showers ),
    SnowShowers(R.drawable.fluent_weather_snow_shower_day_24_regular,R.drawable.fluent_weather_snow_shower_night_24_regular, R.string.snow_showers ),
    Thunderstorm(R.drawable.fluent_weather_snow_24_regular,R.drawable.fluent_weather_snow_24_regular, R.string.thunderstorm );
}