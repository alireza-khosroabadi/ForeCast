package com.alireza.eliqtask.data.repository.uiPattern

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UiPatternRepositoryImpl @Inject constructor(private val uiPatternStore: UiPatterDataStore) : UiPatternRepository {
    override fun uiPattern(): Flow<DataModel<UiPattern>>  = flow {
        uiPatternStore.getUiPattern("UiPattern.JSON")?.let {uiPattern->
            emit(DataModel.Success(uiPattern))
        }
    }
}