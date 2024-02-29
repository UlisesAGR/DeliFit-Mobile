package com.delifit.delifitmobile.home

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.utils.ListMock.ingredientsList
import com.delifit.delifitmobile.utils.ListMock.recipeList
import com.delifit.delifitmobile.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun homeFragment_Validate_EmptyState_Visibility() {
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(emptyList())
            setIngredientsAdapterList(emptyList())
            validateLayoutVisibility(0)
        }

        onView(withId(R.id.homeLayout))
            .check(matches(not(ViewMatchers.isDisplayed())))

        onView(withId(R.id.homeEmptyState))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun click_SearchBar_And_Navigate_To_SearchFragment() {
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
            setIngredientsAdapterList(ingredientsList)
            validateLayoutVisibility(3)
        }

        onView(withId(R.id.searchView))
            .perform(ViewActions.click())

        verify(navController).navigate(
            HomeFragmentDirections.actionHomeFragmentToSearchFragment(),
        )
    }

    @Test
    fun homeFragment_Validate_Subtitle_Is_Correct() {
        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
            setIngredientsAdapterList(ingredientsList)
            validateLayoutVisibility(3)
        }

        val subTitle =
            ApplicationProvider.getApplicationContext<Context>()
                .getString(R.string.app_recipes)

        onView(withId(R.id.subtitle)).check(matches(withText(subTitle)))
    }

    @Test
    fun click_SearchBar_And_Navigate_To_DetailFragment() {
        val navController = Mockito.mock(NavController::class.java)
        val positionId = 0

        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), navController)
            setRecipeAdapterList(recipeList)
            setIngredientsAdapterList(ingredientsList)
            validateLayoutVisibility(3)
        }

        onView(withId(R.id.recipeRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    positionId,
                    ViewActions.click(),
                ),
            )

        verify(navController).navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailActivity(positionId),
        )
    }
}
