package com.delifit.delifitmobile.core.usecase

import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import com.delifit.delifitmobile.core.domain.usecase.GetRecipesUseCase
import com.delifit.delifitmobile.core.utils.DispatcherRule
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipeList
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipesResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
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
class GetRecipesUseCaseTest {
    @Mock
    private lateinit var containerRepository: ContainerRepository

    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        getRecipesUseCase =
            GetRecipesUseCase(
                containerRepository,
            )
    }

    @Test
    fun `Get Recipes From Repository`(): Unit = runBlocking {
        val expected = recipeList
        //Given
        Mockito.`when`(containerRepository.getRecipes()).thenReturn(recipesResponse)
        //When
        val actual = getRecipesUseCase()
        //Then
        Assert.assertEquals(expected, actual.first().data)
    }
}
