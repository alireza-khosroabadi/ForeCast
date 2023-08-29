package com.alireza.eliqtask.base.data.dataModel

sealed class DataModel<out T> {
    data class Success<T>(val data: T) : DataModel<T>()
    data class Error(val error: ErrorModel) : DataModel<Nothing>()
}
