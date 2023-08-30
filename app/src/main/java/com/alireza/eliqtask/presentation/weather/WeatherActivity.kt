package com.alireza.eliqtask.presentation.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alireza.eliqtask.R
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.data.local.entity.UiPattern
import com.alireza.eliqtask.databinding.ActivityWeatherBinding
import com.alireza.eliqtask.domian.model.weather.Weather
import com.alireza.eliqtask.presentation.weather.adapter.WeatherUiAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private var _mBinding: ActivityWeatherBinding? = null
    private val mBinding get() = _mBinding!!

    private val viewModel: WeatherViewModel by viewModels()
    private val homeAdapter: WeatherUiAdapter by lazy { WeatherUiAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflateView()
        setupMainUiRecyclerView()
        observeUiState()
        setupUiListener()
    }

    private fun inflateView() {
        _mBinding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    private fun setupMainUiRecyclerView() {
        mBinding.baseUi.adapter = homeAdapter
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            viewModel.uiWeatherState
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { state ->
                    when (state) {
                        is WeatherViewState.ErrorData -> {
                            showLoading(false)
                            showError(true, state.error)
                        }

                        is WeatherViewState.Loading -> {
                            showError(false)
                            showLoading(state.isLoading)
                        }

                        is WeatherViewState.WeatherData -> {
                            showLoading(false)
                            showData(state.weather, state.uiPattern)
                        }
                    }
                }
        }
    }

    private fun showData(weather: Weather, uiPattern: UiPattern) {
        homeAdapter.setWeatherDetails(weather)
        homeAdapter.submitList(uiPattern.pattern)
    }

    private fun showLoading(loading: Boolean) {
        mBinding.progress.isVisible = loading
    }

    private fun showError(isError: Boolean, error: ErrorModel? = null) {
        mBinding.errorLayout.errorLayoutContainer.isVisible = isError
        mBinding.errorLayout.tvError.text = error?.errorMessage
    }

    private fun setupUiListener() {
        mBinding.errorLayout.btnRetry.setOnClickListener {
            viewModel.loadWeather()
        }

        mBinding.refreshLayout.setOnRefreshListener{
            viewModel.loadWeather()
            mBinding.refreshLayout.isRefreshing = false
        }
    }

}