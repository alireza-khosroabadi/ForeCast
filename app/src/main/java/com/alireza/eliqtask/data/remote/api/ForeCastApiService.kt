package com.alireza.eliqtask.data.remote.api

import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.SimpleTimeZone

interface ForeCastApiService {
    @GET(FORECAST_URL)
    suspend fun foreCast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): Response<WeatherResponse>
}