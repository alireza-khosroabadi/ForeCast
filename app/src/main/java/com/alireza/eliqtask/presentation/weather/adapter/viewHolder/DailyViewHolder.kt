package com.alireza.eliqtask.presentation.weather.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.databinding.DailyWeatherHolderBinding
import com.alireza.eliqtask.domian.model.weather.Daily

class DailyViewHolder(private val mBinding: DailyWeatherHolderBinding) :
    RecyclerView.ViewHolder(mBinding.root) {
    fun onBind(weather: Daily) {
        mBinding.dailyWeather.updateWeather(weather)
    }
}