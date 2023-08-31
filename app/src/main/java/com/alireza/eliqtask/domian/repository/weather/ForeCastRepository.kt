package com.alireza.eliqtask.domian.repository.weather

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import kotlinx.coroutines.flow.Flow

interface ForeCastRepository {
    fun foreCast(param: ForeCastParam): Flow<DataModel<WeatherResponse>>
}