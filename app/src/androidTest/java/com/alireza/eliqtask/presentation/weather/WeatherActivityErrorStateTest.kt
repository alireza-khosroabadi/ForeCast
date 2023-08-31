package com.alireza.eliqtask.presentation.weather

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.alireza.eliqtask.R
import com.alireza.eliqtask.base.data.dataModel.DataModel
import com.alireza.eliqtask.base.data.dataModel.ErrorModel
import com.alireza.eliqtask.config.waitViewShown
import com.alireza.eliqtask.data.local.file.uiPatternStore.UiPatterDataStore
import com.alireza.eliqtask.data.remote.entity.weather.WeatherResponse
import com.alireza.eliqtask.data.remote.param.ForeCastParam
import com.alireza.eliqtask.data.repository.uiPattern.UiPatternRepositoryImpl
import com.alireza.eliqtask.di.Repository
import com.alireza.eliqtask.domian.repository.uiPattern.UiPatternRepository
import com.alireza.eliqtask.domian.repository.weather.ForeCastRepository
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
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(Repository::class)
class WeatherActivityErrorStateTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule(order= 1)
    val activityRule = ActivityScenarioRule(WeatherActivity::class.java)

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
        fun provideFakeWeatherRepository(): ForeCastRepository = object : ForeCastRepository {
            override fun foreCast(param: ForeCastParam): Flow<DataModel<WeatherResponse>> {
                return flow {
                    delay(500)
                    emit(DataModel.Error(ErrorModel(0,"test"))) }
            }
        }
    }

    @Test
    fun when_api_return_error_show_error_state() {
        //step one show loading
        onView(withId(R.id.progress))
            .check(matches(isDisplayed()))
        //wait until error layout shows
        waitViewShown(withText("test"))

        //step two error layout show
        onView(withText("test"))
            .check(matches(isDisplayed()))

        //step four hide loading
        onView(withId(R.id.progress))
            .check(matches(not(isDisplayed())))
    }


    @Test
    fun when_api_return_error_show_error_state_click_retry_show_loading() {
        //step one show loading
        onView(withId(R.id.progress))
            .check(matches(isDisplayed()))
        //wait until error layout shows
        waitViewShown(withText(R.string.retry))

        //step two hid loading
        onView(withId(R.id.progress))
            .check(matches(not(isDisplayed())))

        //step three click on retry btn
        onView(withText(R.string.retry))
            .perform(click())

        //step four show loading
        onView(withId(R.id.progress))
            .check(matches((isDisplayed())))
    }

}