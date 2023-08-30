package com.alireza.eliqtask.data.remote.api

internal const val FORECAST_URL = "/v1/forecast?latitude=52.5244" +
        "&longitude=13.4105" +
        "&hourly=temperature_2m,rain,weathercode,surface_pressure,windspeed_10m" +
        "&daily=weathercode,temperature_2m_max,temperature_2m_min,windspeed_10m_max" +
        "&current_weather=true" +
        "&timezone=Europe%2FBerlin"