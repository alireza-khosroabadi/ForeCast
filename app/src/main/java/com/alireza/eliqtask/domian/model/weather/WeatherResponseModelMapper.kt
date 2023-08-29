package com.alireza.eliqtask.domian.model.weather

import com.alireza.eliqtask.data.remote.entity.weather.CurrentWeatherResponse
import com.alireza.eliqtask.data.remote.entity.weather.DailyResponse
import com.alireza.eliqtask.data.remote.entity.weather.DailyUnitsResponse
import com.alireza.eliqtask.data.remote.entity.weather.HourlyResponse
import com.alireza.eliqtask.data.remote.entity.weather.HourlyUnitsResponse
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse

class WeatherResponseModelMapper(private val weatherResponse: WeatherResponse) {
    private val currentWeather: CurrentWeather by lazy { generateCurrentWeather(weatherResponse.currentWeather) }
    private val daily: Daily
    private val hourly: Hourly

    init {
        daily = generateDaily(weatherResponse.daily, weatherResponse.dailyUnits)
        hourly = generateHourly(weatherResponse.hourly, weatherResponse.hourlyUnits)
    }

    fun toDomainModel(): Weather {
        return Weather(
            time = weatherResponse.generationTimeMs,
            utcOffsetSeconds = weatherResponse.utcOffsetSeconds,
            currentWeather = currentWeather,
            daily = daily,
            hourly = hourly
        )
    }


    private fun generateCurrentWeather(weatherResponse: CurrentWeatherResponse?): CurrentWeather =
        CurrentWeather(
            temperature = weatherResponse?.temperature,
            windSpeed = weatherResponse?.windspeed,
            windDirection = weatherResponse?.winddirection,
            weatherCode = weatherResponse?.weathercode,
            isDay = weatherResponse?.isDay,
            time = weatherResponse?.time
        )

    private fun generateHourly(hourly: HourlyResponse?, hourlyUnits: HourlyUnitsResponse?): Hourly {
        val hourlyList = hourly?.time?.mapIndexed { index, time ->
            HourlyData(
                time = time,
                temperature2m = hourly.temperature2m[index],
                weatherCode = hourly.weathercode[index]
            )
        } ?: listOf()
        return Hourly(
            timeUnit = hourlyUnits?.time ?: "",
            temperature2mUnit = hourlyUnits?.temperature2m ?: "",
            weatherCodeUnit = hourlyUnits?.weathercode ?: "",
            data = hourlyList
        )
    }

    private fun generateDaily(daily: DailyResponse?, dailyUnits: DailyUnitsResponse?): Daily {
        val dailyList = daily?.time?.mapIndexed { index, time ->
            DailyData(
                time = time,
                weatherCode = daily.weathercode[index],
                temperature2mMax = daily.temperature2mMax[index],
                temperature2mMin = daily.temperature2mMin[index]
            )
        } ?: listOf()
        return Daily(
            timeUnit = dailyUnits?.time ?: "",
            weatherCodeUnit = dailyUnits?.weathercode ?: "",
            temperature2mMaxUnit = dailyUnits?.temperature2mMax ?: "",
            temperature2mMinUnit = dailyUnits?.temperature2mMin ?: "",
            data = dailyList
        )
    }


}