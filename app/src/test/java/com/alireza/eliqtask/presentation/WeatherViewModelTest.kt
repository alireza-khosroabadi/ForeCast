package com.alireza.eliqtask.presentation

import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.data.local.entity.UiModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.domian.model.weather.Weather
import com.alireza.eliqtask.domian.useCase.foreCast.ForeCastUseCase
import com.alireza.eliqtask.domian.useCase.uiPattern.UiPatternUseCase
import com.alireza.eliqtask.presentation.weather.WeatherViewModel
import com.alireza.eliqtask.presentation.weather.WeatherViewState
import com.alireza.eliqtask.presentation.rule.MainCoroutineRule
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class WeatherViewModelTest {

    private lateinit var uiPatternUseCase: UiPatternUseCase
    private lateinit var foreCastUseCase: ForeCastUseCase
    private lateinit var weatherViewModel: WeatherViewModel

    @get:Rule
    val rule = MainCoroutineRule()


    @Before
    fun setUp() {

        uiPatternUseCase = mock()
        foreCastUseCase = mock()
        weatherViewModel = WeatherViewModel(uiPatternUseCase, foreCastUseCase)
    }


    @Test
    fun `view model emit loading`() = runTest {
        `when`(uiPatternUseCase()).thenAnswer {
            flow<UseCaseModel<UiPattern>> { emit(UseCaseModel.Success(UiPattern(listOf()))) }
        }

        `when`(foreCastUseCase()).thenAnswer {
            flow<UseCaseModel<Weather>> { emit(UseCaseModel.Success(Weather())) }
        }

        weatherViewModel.loadWeather()

        val data = weatherViewModel.uiWeatherState.take(1).toList()[0]
        assertTrue(data is WeatherViewState.Loading)
    }

    @Test
    fun `view model emit success`() = runTest {
        `when`(uiPatternUseCase()).thenAnswer {
            flow<UseCaseModel<UiPattern>> { emit(UseCaseModel.Success(UiPattern(listOf()))) }
        }

        `when`(foreCastUseCase()).thenAnswer {
            flow<UseCaseModel<Weather>> { emit(UseCaseModel.Success(Weather())) }
        }

        weatherViewModel.loadWeather()

        val data = weatherViewModel.uiWeatherState.take(2).toList()[1]
        assertTrue(data is WeatherViewState.WeatherData)
    }

    @Test
    fun `view model sort UiPattern correct`() = runTest {
        `when`(uiPatternUseCase()).thenAnswer {
            flow<UseCaseModel<UiPattern>> {
                emit(UseCaseModel.Success(
                        UiPattern(
                            listOf(
                                UiModel("Type One", true, 1),
                                UiModel("Type Two", true, 0)
                            )
                        )
                    )
                )
            }
        }

        `when`(foreCastUseCase()).thenAnswer {
            flow<UseCaseModel<Weather>> { emit(UseCaseModel.Success(Weather())) }
        }

        weatherViewModel.loadWeather()

        val data = weatherViewModel.uiWeatherState.take(2).toList()[1]
        assertTrue(data is WeatherViewState.WeatherData)
        assertEquals("Type Two", (data as WeatherViewState.WeatherData).uiPattern.pattern[0].type)
    }

    @Test
    fun `view model filter invisible ui patterns`() = runTest {
        `when`(uiPatternUseCase()).thenAnswer {
            flow<UseCaseModel<UiPattern>> {
                emit(UseCaseModel.Success(
                    UiPattern(
                        listOf(
                            UiModel("Type One", true, 1),
                            UiModel("Type Two", false, 0),
                            UiModel("Type Three", true, 3),
                        )
                    )
                )
                )
            }
        }

        `when`(foreCastUseCase()).thenAnswer {
            flow<UseCaseModel<Weather>> { emit(UseCaseModel.Success(Weather())) }
        }

        weatherViewModel.loadWeather()

        val data = weatherViewModel.uiWeatherState.take(2).toList()[1]
        assertTrue(data is WeatherViewState.WeatherData)
        assertEquals(2, (data as WeatherViewState.WeatherData).uiPattern.pattern.size)
    }

    @Test
    fun `view model emit Error`() = runTest {
        `when`(uiPatternUseCase()).thenAnswer {
            flow<UseCaseModel<UiPattern>> { emit(UseCaseModel.Success(UiPattern(listOf()))) }
        }

        `when`(foreCastUseCase()).thenAnswer {
            flow<UseCaseModel<Weather>> { emit(UseCaseModel.Exception(NullPointerException())) }
        }

        weatherViewModel.loadWeather()

        val data = weatherViewModel.uiWeatherState.take(2).toList()[1]
        assertTrue(data is WeatherViewState.ErrorData)
        assertEquals("Unknown Error", (data as WeatherViewState.ErrorData).error.errorMessage)
    }
}