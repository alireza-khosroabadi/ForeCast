package com.alireza.eliqtask.config

import android.view.View
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import java.lang.reflect.Field

class ViewShownIdlingResource(private val viewMatcher: Matcher<View>) :
    IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null
    override fun isIdleNow(): Boolean {
        val view = getView(viewMatcher)
        val idle = view == null || view.isShown
        if (idle && resourceCallback != null) {
            resourceCallback!!.onTransitionToIdle()
        }
        return idle
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    override fun getName(): String {
        return this.toString() + viewMatcher.toString()
    }

    companion object {
        private val TAG = ViewShownIdlingResource::class.java.simpleName
        private fun getView(viewMatcher: Matcher<View>): View? {
            return try {
                val viewInteraction = onView(viewMatcher)
                val finderField: Field = viewInteraction.javaClass.getDeclaredField("viewFinder")
                finderField.isAccessible = true
                val finder = finderField.get(viewInteraction) as ViewFinder
                finder.view
            } catch (e: java.lang.Exception) {
                null
            }
        }
    }
}

fun waitViewShown(matcher: Matcher<View>) {
    val idlingResource: IdlingResource = ViewShownIdlingResource(matcher) ///
    try {
        IdlingRegistry.getInstance().register(idlingResource)
        onView(matcher).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    } finally {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}
