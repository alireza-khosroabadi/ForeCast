package com.alireza.eliqtask.domian.useCase.foreCast

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.domian.model.weather.Weather
import com.alireza.eliqtask.domian.model.weather.WeatherResponseModelMapper
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ForeCastUseCase @Inject constructor(private val foreCastRepository: ForeCastRepository) {

    operator fun invoke(): Flow<UseCaseModel<Weather>> {
        return foreCastRepository.foreCast().map { dataModel ->
            when (dataModel) {
                is DataModel.Error -> UseCaseModel.Error(dataModel.error)
                is DataModel.Success -> UseCaseModel.Success(WeatherResponseModelMapper(dataModel.data).toDomainModel())
            }
        }.catch { exception ->
            exception.printStackTrace()
            emit(UseCaseModel.Exception(exception))
        }
    }
}