package com.delifit.delifitmobile.search

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.utils.Mocks.recipeList
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
class SearchFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun searchFragment_Validate_Visibility() {
        val navController = mock(NavController::class.java)

        launchFragmentInHiltContainer<SearchFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
        }

        onView(withId(R.id.searchLayoutRoot))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun click_Button_And_Navigate_Go_To_Back() {
        val navController = mock(NavController::class.java)

        launchFragmentInHiltContainer<SearchFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
        }

        onView(withId(R.id.backImageView))
            .perform(ViewActions.click())

        verify(navController).popBackStack()
    }

    @Test
    fun click_RecyclerView_And_Navigate_To_DetailFragment() {
        val navController = mock(NavController::class.java)
        val positionId = 0

        launchFragmentInHiltContainer<SearchFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
        }

        onView(withId(R.id.searchRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    positionId,
                    ViewActions.click(),
                ),
            )

        verify(navController).navigate(
            SearchFragmentDirections.actionSearchFragmentToDetailFragment(positionId),
        )
    }
}
