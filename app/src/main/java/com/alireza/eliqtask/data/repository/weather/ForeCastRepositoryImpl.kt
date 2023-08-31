package com.alireza.eliqtask.data.repository.weather

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.data.remote.api.ForeCastApiService
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.utils.network.NetworkConnectivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ForeCastRepositoryImpl @Inject constructor(
    private val internetConnection: NetworkConnectivity,
    private val apiService: ForeCastApiService,
) : ForeCastRepository {
    override fun foreCast(param:ForeCastParam): Flow<DataModel<WeatherResponse>> {
        if (internetConnection.isInternetOn().not())
            return flowOf(DataModel.Error(ErrorModel(10, "network connection error")))
        val result= flow { emit(apiService.foreCast(param.latitude,param.longitude)) }.map { response ->
            if (response.isSuccessful) {
                val successData = response.body()
                if (successData != null) {
                    DataModel.Success(successData)
                } else {
                    DataModel.Error(ErrorModel(0, "Empty response body"))
                }
            } else {
                val errorData = response.errorBody()?.string() ?: "Unknown error"
                DataModel.Error(ErrorModel(response.code(), errorData))
            }
        }.catch { e-> e.printStackTrace() }

       return  result
    }
}