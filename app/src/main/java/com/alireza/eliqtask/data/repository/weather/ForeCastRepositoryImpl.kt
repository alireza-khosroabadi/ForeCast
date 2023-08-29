package com.alireza.eliqtask.data.repository.weather

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.data.remote.api.ForeCastApiService
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.utils.network.NetworkConnectivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ForeCastRepositoryImpl @Inject constructor(
    private val internetConnection: NetworkConnectivity,
    private val apiService: ForeCastApiService,
) : ForeCastRepository {
    override fun foreCast(): Flow<DataModel<WeatherResponse>> {
        if (internetConnection.isInternetOn().not())
            return flowOf(DataModel.Error(ErrorModel(10, "network connection error")))
        return flow {
            val response = apiService.foreCast()
            if (response.isSuccessful) {
                val successData = response.body()
                if (successData != null) {
                    emit(DataModel.Success(successData))
                } else {
                    emit(DataModel.Error(ErrorModel(0, "Empty response body")))
                }
            } else {
                val errorData = response.errorBody()?.string() ?: "Unknown error"
                emit(DataModel.Error(ErrorModel(response.code(), errorData)))
            }
        }
    }
}