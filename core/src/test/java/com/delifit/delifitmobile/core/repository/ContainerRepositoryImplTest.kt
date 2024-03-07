package com.delifit.delifitmobile.core.repository

import com.delifit.delifitmobile.core.data.repository.ContainerRepositoryImpl
import com.delifit.delifitmobile.core.data.source.ContainerDataSource
import com.delifit.delifitmobile.core.domain.provider.IngredientProvider
import com.delifit.delifitmobile.core.utils.DispatcherRule
import com.delifit.delifitmobile.core.utils.mock.IngredientMock.ingredientsList
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipeList
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipesResponseSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
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
class ContainerRepositoryImplTest {
    @Mock
    private lateinit var ingredientProvider: IngredientProvider

    @Mock
    private lateinit var containerDataSource: ContainerDataSource

    private lateinit var containerRepositoryImpl: ContainerRepositoryImpl

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        containerRepositoryImpl =
            ContainerRepositoryImpl(
                ingredientProvider,
                containerDataSource,
                TestCoroutineDispatcher(),
            )
    }

    @Test
    fun `Get Ingredients From Data Source`(): Unit = runBlocking {
        val expected = ingredientsList
        //Given
        Mockito.`when`(ingredientProvider.getIngredients()).thenReturn(ingredientsList)
        //When
        val actual = containerRepositoryImpl.getIngredients()
        //Then
        Assert.assertEquals(expected, actual.first())
    }

    @Test
    fun `Get Recipes From Data Source`(): Unit = runBlocking {
        val expected = recipeList
        //Given
        Mockito.`when`(containerDataSource.getRecipes()).thenReturn(recipesResponseSuccess)
        //When
        val actual = containerRepositoryImpl.getRecipes()
        //Then
        Assert.assertEquals(expected, actual.first().data)
    }
}
