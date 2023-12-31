package com.alireza.eliqtask.data.remote.api

internal const val FORECAST_URL = "/v1/forecast?"+
        "&hourly=temperature_2m,weathercode,windspeed_10m,precipitation_probability" +
        "&daily=weathercode,temperature_2m_max,temperature_2m_min,windspeed_10m_max" +
        "&current_weather=true"+
        "&timezone=auto"