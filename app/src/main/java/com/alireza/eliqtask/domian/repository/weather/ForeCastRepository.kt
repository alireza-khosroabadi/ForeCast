package com.alireza.eliqtask.domian.repository.weather

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface ForeCastRepository {
    fun foreCast(): Flow<DataModel<WeatherResponse>>
}