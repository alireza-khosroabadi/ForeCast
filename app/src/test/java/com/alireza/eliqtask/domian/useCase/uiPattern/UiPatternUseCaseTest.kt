package com.alireza.eliqtask.domian.useCase.uiPattern

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.data.local.entity.UiModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.data.repository.uiPattern.UiPatternRepositoryImpl
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
class UiPatternUseCaseTest {

    private lateinit var uiPatternRepository: UiPatternRepository
    private lateinit var uiPatterDataStore: UiPatterDataStore
    private lateinit var uiPatternUseCase: UiPatternUseCase

    @get:Rule
    val  rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        uiPatterDataStore = mock()
        uiPatternRepository = UiPatternRepositoryImpl(uiPatterDataStore)
        uiPatternUseCase = UiPatternUseCase(uiPatternRepository)
    }



    @Test
    fun `get correct ui pattern`() = runTest {
        `when`(uiPatterDataStore.getUiPattern(any())).thenReturn(UiPattern(listOf(UiModel("Header",true, 0))))

        uiPatternUseCase().collect{model ->
            assertTrue(model is UseCaseModel.Success)
            assertEquals(1 , (model as UseCaseModel.Success).data.pattern.size)

        }
    }
}