package com.alireza.eliqtask.di

import android.app.Application
import android.content.Context
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UiPatterStore {

    @Singleton
    @Provides
    fun provideUiPatternDataStore(@ApplicationContext context: Context, moshi: Moshi) =
        UiPatterDataStore(context, moshi)
}