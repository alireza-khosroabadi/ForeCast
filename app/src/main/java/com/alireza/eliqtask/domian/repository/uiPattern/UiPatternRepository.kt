package com.alireza.eliqtask.domian.repository.uiPattern

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import kotlinx.coroutines.flow.Flow

interface UiPatternRepository {
    fun uiPattern(): Flow<DataModel<UiPattern>>
}