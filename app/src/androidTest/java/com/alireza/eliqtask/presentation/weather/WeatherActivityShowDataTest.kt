package com.alireza.eliqtask.presentation.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.alireza.eliqtask.R
import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import com.alireza.eliqtask.data.repository.uiPattern.UiPatternRepositoryImpl
import com.alireza.eliqtask.di.Repository
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
import com.alireza.eliqtask.config.waitViewShown
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(Repository::class)
class WeatherActivityShowDataTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule(order= 1)
    val activityRule = ActivityScenarioRule(WeatherActivity::class.java)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun injectApiService() {
        hiltAndroidRule.inject()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object FakeWeatherDataRepository {

        @Provides
        fun provideUiPatternRepository(uiPatternStore: UiPatterDataStore): UiPatternRepository =
            UiPatternRepositoryImpl(uiPatternStore)

        @Provides
        fun provideFakeWeatherRepository(): ForeCastRepository = object :ForeCastRepository{
            override fun foreCast(param: ForeCastParam): Flow<DataModel<WeatherResponse>> {
               return flow {
                   delay(500)
                   emit(DataModel.Success(WeatherResponse()))
               }
            }
        }
    }



    @Test
    fun show_recyclerview_and_data_state() {
        //step one show loading
        Espresso.onView(withId(R.id.progress))
            .check(ViewAssertions.matches(isDisplayed()))
        //waiting to receive data
        waitViewShown(withId(R.id.base_ui))
        //step step two show data
        Espresso.onView(withId(R.id.base_ui))
            .check(ViewAssertions.matches(isDisplayed()))
        //step four hide loading
        Espresso.onView(withId(R.id.progress))
            .check(ViewAssertions.matches(not(isDisplayed())))
    }

}