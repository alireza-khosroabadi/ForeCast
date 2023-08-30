package com.alireza.eliqtask.utils.extention

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus

fun getCorrectIconBasedOnDayLight(isDay: Int?, state:WeatherStatus): Int = when(isDay){
    0 -> state.iconDay
    1 -> state.iconNight
    else -> state.iconDay
}