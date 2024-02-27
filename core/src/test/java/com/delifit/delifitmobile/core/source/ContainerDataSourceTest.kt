package com.delifit.delifitmobile.core.source

import com.delifit.delifitmobile.core.data.network.RecipesServices
import com.delifit.delifitmobile.core.data.source.ContainerDataSource
import com.delifit.delifitmobile.core.utils.DispatcherRule
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipeList
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipesDataResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ContainerDataSourceTest {
    @Mock
    private lateinit var recipesServices: RecipesServices

    private lateinit var containerDataSource: ContainerDataSource

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        containerDataSource =
            ContainerDataSource(
                recipesServices,
            )
    }

    @Test
    fun `Get Recipes Test`(): Unit = runBlocking {
        val expected = recipeList
        //Given
        Mockito.`when`(recipesServices.getRecipes()).thenReturn(recipesDataResponse)
        //When
        val actual = containerDataSource.getRecipes().data
        //Then
        Assert.assertEquals(expected, actual)
    }
}
