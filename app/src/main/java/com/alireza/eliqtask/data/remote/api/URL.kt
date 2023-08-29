package com.alireza.eliqtask.data.remote.api

internal const val FORECAST_URL ="/v1/forecast?latitude=52.5244" +
        "&longitude=13.4105" +
        "&hourly=temperature_2m,weathercode" +
        "&daily=weathercode,temperature_2m_max,temperature_2m_min" +
        "&current_weather=true" +
        "&timezone=Europe%2FBerlin"