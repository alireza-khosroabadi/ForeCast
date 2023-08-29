package com.alireza.eliqtask.data.local.entity

data class UiPattern(var pattern:List<UiModel>)
data class UiModel(val type:String, val isVisible:Boolean, val order: Int)
