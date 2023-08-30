package com.alireza.eliqtask.presentation.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.data.local.entity.UiModel
import com.alireza.eliqtask.data.local.entity.ViewPattern
import com.alireza.eliqtask.databinding.CurrentDayWeatherHolderBinding
import com.alireza.eliqtask.databinding.DailyWeatherHolderBinding
import com.alireza.eliqtask.databinding.HourlyWeatherHolderBinding
import com.alireza.eliqtask.domian.model.weather.Weather
import com.alireza.eliqtask.presentation.customeUi.dailyWeather.DailyWeatherAdapter
import com.alireza.eliqtask.presentation.weather.adapter.viewHolder.CurrentDayViewHolder
import com.alireza.eliqtask.presentation.weather.adapter.viewHolder.DailyViewHolder
import com.alireza.eliqtask.presentation.weather.adapter.viewHolder.HourlyViewHolder

class UiPatternDiffCallback : DiffUtil.ItemCallback<UiModel>() {

    override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        return oldItem.type == newItem.type
                && oldItem.order == newItem.order
                && oldItem.isVisible == newItem.isVisible
    }

    override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        return oldItem == newItem
    }
}

class WeatherUiAdapter : ListAdapter<UiModel, RecyclerView.ViewHolder>(UiPatternDiffCallback()) {

    private var weatherDetail: Weather? = null
    private var inflater:LayoutInflater? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            ViewPattern.CurrentWeather.ordinal -> CurrentDayViewHolder(CurrentDayWeatherHolderBinding.inflate(inflater!!,parent,false))
            ViewPattern.Hourly.ordinal -> HourlyViewHolder(HourlyWeatherHolderBinding.inflate(inflater!!,parent,false))
            ViewPattern.Daily.ordinal -> DailyViewHolder(DailyWeatherHolderBinding.inflate(inflater!!,parent,false))
            else -> CurrentDayViewHolder(CurrentDayWeatherHolderBinding.inflate(inflater!!,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder){
           is CurrentDayViewHolder ->  weatherDetail?.currentWeather?.let { holder.onBind(it) }
           is HourlyViewHolder ->  weatherDetail?.hourly?.let { holder.onBind(it) }
           is DailyViewHolder ->  weatherDetail?.daily?.let { holder.onBind(it) }
       }
    }

    fun setWeatherDetails(weather: Weather){
        weatherDetail = weather
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }
}