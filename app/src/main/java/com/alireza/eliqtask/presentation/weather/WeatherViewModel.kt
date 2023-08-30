package com.alireza.eliqtask.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.domian.useCase.foreCast.ForeCastUseCase
import com.alireza.eliqtask.domian.useCase.uiPattern.UiPatternUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val uiPatternUseCase: UiPatternUseCase,
    private val foreCastUseCase: ForeCastUseCase
) : ViewModel() {

    private val _uiWeatherState = MutableStateFlow<WeatherViewState>(WeatherViewState.Loading(true))
    val uiWeatherState = _uiWeatherState.asStateFlow()

    init {
        loadWeather()
    }

    fun loadWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            combine(uiPatternUseCase(), foreCastUseCase()) { uiPattern, weather ->
                when (weather) {
                    is UseCaseModel.Error -> WeatherViewState.ErrorData(weather.error)
                    is UseCaseModel.Exception -> WeatherViewState.ErrorData(
                        ErrorModel(
                            0,
                            "Unknown Error"
                        )
                    )

                    is UseCaseModel.Success -> WeatherViewState.WeatherData(
                        (uiPattern as UseCaseModel.Success).data.apply {
                            pattern = pattern.filter { it.isVisible }.sortedBy { it.order }
                        },
                        weather.data
                    )
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = WeatherViewState.Loading(true)
            ).collect { state -> if (state is WeatherViewState.Loading){
                _uiWeatherState.value = state
            }else{
                _uiWeatherState.value = state
            }
            }
        }
    }
}