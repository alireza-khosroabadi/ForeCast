package com.alireza.eliqtask.data.local.entity

data class UiPattern(val uiPattern:List<UiModel>)
data class UiModel(val type:String, val isVisible:Boolean)
