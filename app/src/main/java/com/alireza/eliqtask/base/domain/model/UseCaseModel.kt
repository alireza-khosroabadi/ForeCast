package com.alireza.eliqtask.base.domain.model

import com.alireza.eliqtask.base.data.dataModel.ErrorModel

/**
 * UseCaseModel is wrapper to hold data and exceptions and pass to presentation layer (ViewModels)
 * T is a Generic model to hold data model requested
 * */
sealed class UseCaseModel<out T> {
    data class Success<T>(val data: T) : UseCaseModel<T>()
    data class Error(val error: ErrorModel) : UseCaseModel<Nothing>()
    data class Exception(val error: Throwable) : UseCaseModel<Nothing>()
}
