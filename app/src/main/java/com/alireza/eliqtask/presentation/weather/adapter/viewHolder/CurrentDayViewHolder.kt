package com.alireza.eliqtask.presentation.weather.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.databinding.CurrentDayWeatherHolderBinding
import com.alireza.eliqtask.domian.model.weather.CurrentWeather

class CurrentDayViewHolder(private val mBinding: CurrentDayWeatherHolderBinding) :
    RecyclerView.ViewHolder(mBinding.root) {
    fun onBind(weather: CurrentWeather) {
        mBinding.location.text = weather.time
    }
}