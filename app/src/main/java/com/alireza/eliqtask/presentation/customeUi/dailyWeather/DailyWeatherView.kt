package com.alireza.eliqtask.presentation.customeUi.dailyWeather

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.alireza.eliqtask.databinding.DailyWeatherViewBinding
import com.alireza.eliqtask.domian.model.weather.Daily

class DailyWeatherView @JvmOverloads constructor(
    ctx: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(ctx, attributeSet, defStyleAttr, defStyleRes) {


    private val dailyAdapter: DailyWeatherAdapter by lazy { DailyWeatherAdapter() }
    private val binding: DailyWeatherViewBinding = DailyWeatherViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

        init {
           setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rcDaily){
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = dailyAdapter
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }
    }

    fun updateWeather(weather:Daily){
        dailyAdapter.submitList(weather.data)
    }
}