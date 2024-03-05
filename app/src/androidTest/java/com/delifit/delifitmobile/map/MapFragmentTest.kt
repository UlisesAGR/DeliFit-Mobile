package com.delifit.delifitmobile.map

import android.content.Context
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.ui.map.MapFragment
import com.delifit.delifitmobile.utils.Mocks.recipe
import com.delifit.delifitmobile.utils.launchFragmentInHiltContainer
import com.google.android.gms.maps.SupportMapFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class MapFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun mapFragment_Validate_Visibility() {
        val navController = Mockito.mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<MapFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            (childFragmentManager.findFragmentById(R.id.mapFrameLayout) as SupportMapFragment)
                .getMapAsync { map ->
                    googleMap = map
                    createMarker(recipe)
                }
        }

        onView(withId(R.id.mapLayoutRoot))
            .check(matches(isDisplayed()))
    }

    @Test
    fun validate_Title_MaterialToolbar() {
        val navController = Mockito.mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<MapFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            (childFragmentManager.findFragmentById(R.id.mapFrameLayout) as SupportMapFragment)
                .getMapAsync { map ->
                    googleMap = map
                    createMarker(recipe)
                }
        }

        val title =
            ApplicationProvider.getApplicationContext<Context>()
                .getString(R.string.app_map)

        onView(withId(R.id.mapToolbar))
            .check(matches(hasDescendant(withText(title))))
    }

    @Test
    fun fragmentContainerView_Validate_Visibility() {
        val navController = Mockito.mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<MapFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            (childFragmentManager.findFragmentById(R.id.mapFrameLayout) as SupportMapFragment)
                .getMapAsync { map ->
                    googleMap = map
                    createMarker(recipe)
                }
        }

        onView(withId(R.id.mapFrameLayout))
            .check(matches(isDisplayed()))
    }

    @Test
    fun homeFragment_Validate_Description_Is_Correct() {
        val navController = Mockito.mock(NavController::class.java)

        val args = bundleOf("id" to 0)
        launchFragmentInHiltContainer<MapFragment>(args) {
            Navigation.setViewNavController(requireView(), navController)
            (childFragmentManager.findFragmentById(R.id.mapFrameLayout) as SupportMapFragment)
                .getMapAsync { map ->
                    googleMap = map
                    createMarker(recipe)
                }
        }

        val description =
            ApplicationProvider.getApplicationContext<Context>()
                .getString(R.string.app_click_on_the_pointer_to_know_name)

        onView(withId(R.id.descriptionTextView))
            .check(matches(withText(description)))
    }
}
