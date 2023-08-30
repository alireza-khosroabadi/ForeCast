package com.alireza.eliqtask.presentation.customeUi.dailyWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alireza.eliqtask.databinding.ListItemDailyWeatherBinding
import com.alireza.eliqtask.domian.model.weather.DailyData

class DailyWeatherAdapter: ListAdapter<DailyData,DailyWeatherAdapter.ViewHolder >(DiffCallback()) {

    private var layoutInflater:LayoutInflater?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutInflater== null)
            layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ListItemDailyWeatherBinding.inflate(layoutInflater!!,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding:ListItemDailyWeatherBinding):RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: DailyData){
            binding.tvTemp.text = data.temperature
            binding.tvDay.text = data.time
            binding.tvRain.text = data.weatherCode.toString()
            binding.imgWeatherStatus.setImageResource(data.weatherCode.iconDay)
        }
    }

}


class DiffCallback: DiffUtil.ItemCallback<DailyData>() {
    override fun areItemsTheSame(oldItem: DailyData, newItem: DailyData) =
        oldItem.time == newItem.time

    override fun areContentsTheSame(oldItem: DailyData, newItem: DailyData) =
        oldItem == newItem
}