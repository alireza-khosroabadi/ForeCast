package com.alireza.eliqtask.utils.extension

import com.alireza.eliqtask.data.remote.entity.weather.WeatherStatus


/**
 * whit this function I select day or night icon to show, develop this function because I need this selection in multiple place
 * */
fun getCorrectIconBasedOnDayLight(isDay: Int?, state:WeatherStatus): Int = when(isDay){
    0 -> state.iconDay
    1 -> state.iconNight
    else -> state.iconDay
}