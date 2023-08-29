package com.alireza.eliqtask.presentation.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.data.local.entity.UiModel
import com.alireza.eliqtask.databinding.CurrentDayWeatherHolderBinding
import com.alireza.eliqtask.domian.model.weather.Weather
import com.alireza.eliqtask.presentation.weather.adapter.viewHolder.CurrentDayViewHolder

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


    private val uiPattern = mutableListOf<UiModel>()
    private var weatherDetail: Weather? = null
    private var inflater:LayoutInflater? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.context)
        return CurrentDayViewHolder(CurrentDayWeatherHolderBinding.inflate(inflater!!,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        weatherDetail?.currentWeather?.let { (holder as CurrentDayViewHolder).onBind(it) }
    }

    fun setWeatherDetails(weather: Weather){
        weatherDetail = weather
    }
}