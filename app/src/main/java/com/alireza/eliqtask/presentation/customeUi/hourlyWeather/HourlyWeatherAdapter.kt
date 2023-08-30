package com.alireza.eliqtask.presentation.customeUi.hourlyWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.databinding.ListItemHourlyWeatherBinding
import com.alireza.eliqtask.domian.model.weather.HourlyData

class HourlyWeatherAdapter: ListAdapter<HourlyData,HourlyWeatherAdapter.ViewHolder >(DiffCallback()) {

    private var layoutInflater:LayoutInflater?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater== null)
            layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ListItemHourlyWeatherBinding.inflate(layoutInflater!!,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding:ListItemHourlyWeatherBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HourlyData){
            binding.tvTemp.text = data.temperature2m
            binding.tvHour.text = data.time
            binding.tvRain.text = data.rain
            binding.imgWeatherStatus.setImageResource(data.weatherCode.iconDay)
        }
    }

}


class DiffCallback: DiffUtil.ItemCallback<HourlyData>() {
    override fun areItemsTheSame(oldItem: HourlyData, newItem: HourlyData) =
        oldItem.time == newItem.time

    override fun areContentsTheSame(oldItem: HourlyData, newItem: HourlyData) =
        oldItem == newItem
}