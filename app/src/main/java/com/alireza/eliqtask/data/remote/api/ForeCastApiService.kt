package com.alireza.eliqtask.data.remote.api

import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import retrofit2.http.GET

interface ForeCastApiService {
    @GET(FORECAST_URL)
    suspend fun foreCast():WeatherResponse
}