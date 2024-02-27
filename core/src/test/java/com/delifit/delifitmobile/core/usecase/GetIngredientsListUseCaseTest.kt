package com.delifit.delifitmobile.core.usecase

import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import com.delifit.delifitmobile.core.domain.usecase.GetIngredientsListUseCase
import com.delifit.delifitmobile.core.utils.DispatcherRule
import com.delifit.delifitmobile.core.utils.mock.IngredientMock.ingredientsList
import com.delifit.delifitmobile.core.utils.mock.IngredientMock.ingredientsListResponse
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
class GetIngredientsListUseCaseTest {

    @Mock
    private lateinit var containerRepository: ContainerRepository

    private lateinit var getIngredientsListUseCase: GetIngredientsListUseCase

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        getIngredientsListUseCase = GetIngredientsListUseCase(
            containerRepository,
        )
    }

    @Test
    fun `Get Get Ingredients Test`(): Unit = runBlocking {
        val expected = ingredientsList
        //Given
        Mockito.`when`(containerRepository.getIngredients()).thenReturn(ingredientsListResponse)
        //When
        getIngredientsListUseCase().collect { ingredients ->
            //Then
            Assert.assertEquals(expected, ingredients)
        }
    }
}