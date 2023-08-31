package com.alireza.eliqtask.domian.useCase.foreCast

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.data.remote.api.ForeCastApiService
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import com.alireza.eliqtask.data.repository.weather.ForeCastRepositoryImpl
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.base.utils.network.NetworkConnectivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class ForeCastUseCaseTest {

    private val fakeParam: ForeCastParam by lazy { ForeCastParam("test",0.0,0.0) }
    private lateinit var apiService: ForeCastApiService
    private lateinit var networkConnectivity: NetworkConnectivity
    private lateinit var foreCastUseCase: ForeCastUseCase
    private lateinit var foreCastRepository: ForeCastRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        apiService = mock()
        networkConnectivity = mock {
            on { isInternetOn() } doReturn true
        }

        foreCastRepository = ForeCastRepositoryImpl(networkConnectivity, apiService)
        foreCastUseCase = ForeCastUseCase(foreCastRepository)
    }


    @Test
    fun `load and map weather data success`() = runTest {
        `when`(apiService.foreCast(any(), any())).thenReturn(Response.success(WeatherResponse()))

        foreCastUseCase.invoke(fakeParam).collect { dataModel ->
            assertTrue(dataModel is UseCaseModel.Success)
            assertTrue((dataModel as UseCaseModel.Success).data.daily.data.isEmpty())
        }
    }

}