package com.alireza.eliqtask.di

import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.data.remote.api.ForeCastApiService
import com.alireza.eliqtask.data.repository.uiPattern.UiPatternRepositoryImpl
import com.alireza.eliqtask.data.repository.weather.ForeCastRepositoryImpl
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.utils.network.NetworkConnectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Repository {

    @Provides
    fun provideUiPatternRepository(uiPatternStore: UiPatterDataStore): UiPatternRepository =
        UiPatternRepositoryImpl(uiPatternStore)

    @Provides
    fun provideWeatherRepository(
        networkConnectivity: NetworkConnectivity,
        apiService: ForeCastApiService
    ): ForeCastRepository = ForeCastRepositoryImpl(networkConnectivity, apiService)
}