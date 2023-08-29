package com.alireza.eliqtask.domian.model.weather

data class Daily(
    var timeUnit             : String="",
    var weatherCodeUnit      : String="",
    var temperature2mMaxUnit : String="",
    var temperature2mMinUnit : String="",
    var data                 : List<DailyData> = listOf()
)

data class DailyData(
    var time: String,
    var weatherCode: Int,
    var temperature2mMax: Double,
    var temperature2mMin: Double
)