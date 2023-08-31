package com.alireza.eliqtask.presentation.weather

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.alireza.eliqtask.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class WeatherActivityTest {

    @get:Rule(order = 0)
    val hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule(order= 1)
    val activityRule = ActivityScenarioRule(WeatherActivity::class.java)

    @Test
    fun show_loading_state() {
        Espresso.onView(withId(R.id.progress))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}