package com.alireza.eliqtask.data.repository.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.remote.api.ForeCastApiService
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.base.utils.network.NetworkConnectivity
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
class ForeCastRepositoryImplTest {
    private val fakeParam: ForeCastParam by lazy { ForeCastParam("test",0.0,0.0) }
    private lateinit var apiService: ForeCastApiService
    private lateinit var repository: ForeCastRepository
    private lateinit var networkConnectivity: NetworkConnectivity

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        apiService = mock()
        networkConnectivity = mock{
            on { isInternetOn() } doReturn true
        }
        repository = ForeCastRepositoryImpl(networkConnectivity, apiService)
    }

    @Test
    fun `fetchData emits SuccessResponse when API call is successful`() = runTest{
        val mockResponse = Response.success(WeatherResponse(elevation = 10))
        `when`(apiService.foreCast(any(), any())).thenAnswer { mockResponse }

        repository.foreCast(fakeParam).collect { response ->
            assertTrue(response is DataModel.Success)
            assertEquals(10, (response as DataModel.Success).data.elevation)
        }
    }

    @Test
    fun `fetchData emits ErrorResponse when API call is not successful`()= runTest {
        val mockResponse = Response.error<WeatherResponse>(400, mock())
        `when`(apiService.foreCast(any(), any())).thenAnswer { mockResponse }

        repository.foreCast(fakeParam).collect{ response ->
            assertTrue(response is DataModel.Error)
            assertEquals(400, (response as DataModel.Error).error.errorCode)
        }
    }

    @Test
    fun `fetchData emits ErrorResponse when no network connection`()= runTest {
        `when`(networkConnectivity.isInternetOn()).thenReturn(false)

        repository.foreCast(fakeParam).collect{ response ->
            assertTrue(response is DataModel.Error)
            assertEquals(10, (response as DataModel.Error).error.errorCode)
        }
    }
}