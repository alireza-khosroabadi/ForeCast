package com.alireza.eliqtask.presentation.weather.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.databinding.HourlyWeatherHolderBinding
import com.alireza.eliqtask.domian.model.weather.Hourly

class HourlyViewHolder(private val mBinding: HourlyWeatherHolderBinding) :
    RecyclerView.ViewHolder(mBinding.root) {
    fun onBind(weather: Hourly) {
        mBinding.hourlyWeather.updateWeather(weather)
    }
}