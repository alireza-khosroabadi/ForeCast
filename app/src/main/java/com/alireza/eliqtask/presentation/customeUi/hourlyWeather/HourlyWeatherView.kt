package com.alireza.eliqtask.presentation.customeUi.hourlyWeather

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.alireza.eliqtask.databinding.CurrentWeatherViewBinding
import com.alireza.eliqtask.databinding.HourlyWeatherViewBinding
import com.alireza.eliqtask.domian.model.weather.CurrentWeather
import com.alireza.eliqtask.domian.model.weather.Hourly

class HourlyWeatherView @JvmOverloads constructor(
    ctx: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(ctx, attributeSet, defStyleAttr, defStyleRes) {

    private val hourlyAdapter: HourlyWeatherAdapter by lazy { HourlyWeatherAdapter() }
    private val binding: HourlyWeatherViewBinding = HourlyWeatherViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rcHourly){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = hourlyAdapter
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }
    }

    fun updateWeather(weather:Hourly){
        binding.tvDate.text = weather.timeUnit
        hourlyAdapter.submitList(weather.data)
        binding.rcHourly.scrollToPosition(weather.data.indexOfFirst { it.time=="Now" })
    }
}