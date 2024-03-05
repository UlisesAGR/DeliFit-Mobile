package com.delifit.delifitmobile.detail

import android.content.Context
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.ui.detail.DetailFragment
import com.delifit.delifitmobile.ui.detail.DetailFragmentDirections
import com.delifit.delifitmobile.utils.Mocks
import com.delifit.delifitmobile.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class DetailFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun detailFragment_Validate_Visibility() {
        val navController = mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<DetailFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            setData(Mocks.recipe)
        }

        onView(withId(R.id.detailLayoutRoot))
            .check(matches(isDisplayed()))
    }

    @Test
    fun detailFragment_Validate_Text_Labels() {
        val navController = mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<DetailFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            setData(Mocks.recipe)
        }

        onView(withId(R.id.nameTextView))
            .check(matches(withText("Name")))

        onView(withId(R.id.descriptionTextView))
            .check(matches(withText("Description")))

        onView(withId(R.id.smallDescriptionTextView))
            .check(matches(withText("Small Description")))
    }

    @Test
    fun validate_Text_And_click_Map_Button_Navigate_To_MapFragment() {
        val navController = mock(NavController::class.java)
        val positionId = 0

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<DetailFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            setData(Mocks.recipe)
        }

        val mapButtonText =
            ApplicationProvider.getApplicationContext<Context>()
                .getString(R.string.app_go_to_map)

        onView(withId(R.id.mapButton))
            .check(matches(withText(mapButtonText)))

        onView(withId(R.id.mapButton))
            .perform(scrollTo())
            .perform(click())

        verify(navController).navigate(
            DetailFragmentDirections.actionDetailFragmentToMapFragment(positionId),
        )
    }

    @Test
    fun validate_Text_And_click_Back_Button_Go_To_Back() {
        val navController = mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<DetailFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            setData(Mocks.recipe)
        }

        val mapButtonText =
            ApplicationProvider.getApplicationContext<Context>()
                .getString(R.string.app_back)

        onView(withId(R.id.backButton))
            .check(matches(withText(mapButtonText)))

        onView(withId(R.id.backButton))
            .perform(scrollTo())
            .perform(click())

        verify(navController).popBackStack()
    }
}
