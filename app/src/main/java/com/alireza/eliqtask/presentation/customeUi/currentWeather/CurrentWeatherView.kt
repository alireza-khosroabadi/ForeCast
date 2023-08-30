package com.alireza.eliqtask.presentation.customeUi.currentWeather

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.alireza.eliqtask.databinding.CurrentWeatherViewBinding
import com.alireza.eliqtask.domian.model.weather.CurrentWeather
import com.alireza.eliqtask.utils.extension.getCorrectIconBasedOnDayLight

class CurrentWeatherView @JvmOverloads constructor(
    ctx: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(ctx, attributeSet, defStyleAttr, defStyleRes) {

    private val binding: CurrentWeatherViewBinding = CurrentWeatherViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun updateWeather(weather:CurrentWeather){
        binding.tvLocation.text = weather.location
        binding.tvDate.text = weather.time
        binding.tvTemp.text = weather.temperature
        binding.tvWindSpeed.text = weather.windSpeed
        binding.tvPressure.text = weather.windDirection.toString()
        weather.weatherCode?.let { binding.imgWeather.setImageResource(getCorrectIconBasedOnDayLight(weather.isDay,it)) }
    }
}