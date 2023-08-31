package com.alireza.eliqtask.data.repository.uiPattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.local.entity.UiModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.data.local.entity.ViewPattern
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class UiPatternRepositoryImplTest {

    private lateinit var uiPatterDataStore: UiPatterDataStore
    private lateinit var uiPatternRepository: UiPatternRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        uiPatterDataStore = mock()
        uiPatternRepository = UiPatternRepositoryImpl(uiPatterDataStore)
    }


    @Test
    fun `return ui pattern success`() = runTest {
        `when`(uiPatterDataStore.getUiPattern(any())).thenReturn(UiPattern(listOf(UiModel(ViewPattern.CurrentWeather,true, 0))))

        uiPatternRepository.uiPattern().collect{response ->
            assertTrue(response is DataModel.Success)
            assertEquals(1, (response as DataModel.Success).data.pattern.size)
        }
    }
}