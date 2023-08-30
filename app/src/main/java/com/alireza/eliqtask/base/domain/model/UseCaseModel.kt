package com.alireza.eliqtask.base.domain.model

import com.alireza.eliqtask.base.data.dataModel.ErrorModel

sealed class UseCaseModel<out T> {
    data class Success<T>(val data: T) : UseCaseModel<T>()
    data class Error(val error: ErrorModel) : UseCaseModel<Nothing>()
    data class Exception(val error: Throwable) : UseCaseModel<Nothing>()
}
