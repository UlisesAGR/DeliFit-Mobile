package com.delifit.delifitmobile.container

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.delifit.delifitmobile.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ContainerActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(ContainerActivity::class.java)

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun container_Validate_Container_Visibility() {
        onView(withId(R.id.containerLayoutRoot))
            .check(matches(isDisplayed()))
    }
}
