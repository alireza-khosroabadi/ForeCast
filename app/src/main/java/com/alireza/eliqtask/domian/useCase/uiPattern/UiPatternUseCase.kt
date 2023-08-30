package com.alireza.eliqtask.domian.useCase.uiPattern

import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.domain.model.UseCaseModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UiPatternUseCase @Inject constructor(private val uiPatternRepository: UiPatternRepository) {

    operator fun invoke(): Flow<UseCaseModel<UiPattern>> {
        return uiPatternRepository.uiPattern()
            .map { UseCaseModel.Success((it as DataModel.Success).data) }
    }
}