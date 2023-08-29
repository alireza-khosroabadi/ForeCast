package com.alireza.eliqtask.data.local.entity

import com.squareup.moshi.Json

data class UiPattern( @Json var pattern:List<UiModel>)
data class UiModel(val type:String, val isVisible:Boolean, val order: Int)
