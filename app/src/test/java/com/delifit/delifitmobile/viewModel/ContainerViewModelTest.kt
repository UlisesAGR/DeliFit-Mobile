package com.delifit.delifitmobile.viewModel

import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.core.data.provider.TextsProvider
import com.delifit.delifitmobile.core.domain.usecase.GetIngredientsListUseCase
import com.delifit.delifitmobile.core.domain.usecase.GetRecipesUseCase
import com.delifit.delifitmobile.utils.DispatcherRule
import com.delifit.delifitmobile.utils.mock.IngredientMock.ingredientName
import com.delifit.delifitmobile.utils.mock.IngredientMock.ingredientsList
import com.delifit.delifitmobile.utils.mock.IngredientMock.ingredientsListResponse
import com.delifit.delifitmobile.utils.mock.RecipeMock.listFilteredRecipes
import com.delifit.delifitmobile.utils.mock.RecipeMock.recipe
import com.delifit.delifitmobile.utils.mock.RecipeMock.recipeList
import com.delifit.delifitmobile.utils.mock.RecipeMock.recipeListResponseSuccess
import com.delifit.delifitmobile.utils.mock.RecipeMock.recipeName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ContainerViewModelTest {

    @Mock
    private lateinit var getIngredientsListUseCase: GetIngredientsListUseCase

    @Mock
    private lateinit var getRecipesUseCase: GetRecipesUseCase

    @Mock
    private lateinit var textsProvider: TextsProvider

    private lateinit var containerViewModel: ContainerViewModel

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Before
    fun setUp() {
        containerViewModel = ContainerViewModel(
            getIngredientsListUseCase,
            getRecipesUseCase,
            textsProvider,
        )
    }

    @Test
    fun `Get Recipe List Test`(): Unit = runBlocking {
        val expected = recipeList
        //Given
        Mockito.`when`(getRecipesUseCase()).thenReturn(recipeListResponseSuccess)
        //When
        containerViewModel.getRecipesUseCase()
        //Then
        assertEquals(expected, containerViewModel.containerState.value.recipeList)
    }

    @Test
    fun `Get Ingredients List Test`(): Unit = runBlocking {
        val expected = ingredientsList
        //Given
        Mockito.`when`(getIngredientsListUseCase()).thenReturn(ingredientsListResponse)
        //When
        containerViewModel.getIngredientsListUseCase()
        //Then
        assertEquals(expected, containerViewModel.containerState.value.ingredientsList)
    }

    @Test
    fun `Filter By Ingredient`() = runBlocking {
        val expected = listFilteredRecipes
        //Given
        containerViewModel.recipeListCurrent = recipeList
        //When
        containerViewModel.filterByIngredient(ingredientName)
        //Then
        assertEquals(expected, containerViewModel.containerState.value.recipeList)
    }

    @Test
    fun `Filter By Name`() = runBlocking {
        val expected = listFilteredRecipes
        //Given
        containerViewModel.recipeListCurrent = recipeList
        //When
        containerViewModel.filterByName(recipeName)
        //Then
        assertEquals(expected, containerViewModel.containerState.value.recipeList)
    }

    @Test
    fun `Filter By Id`(): Unit = runBlocking {
        val expected = recipe
        val recipeId = 0
        //Given
        containerViewModel.recipeListCurrent = recipeList
        //When
        containerViewModel.getRecipesById(recipeId)
        //Then
        containerViewModel.containerState.value.recipe?.let { recipe ->
            assertEquals(expected, recipe)
            assertEquals(recipeId, recipe.id)
        }
    }

    @Test
    fun `Search Recipe`(): Unit = runBlocking {
        val expected = recipe
        val recipeId = 0
        //Given
        containerViewModel.recipeListCurrent = recipeList
        //When
        val actual = containerViewModel.searchRecipe(recipeId)
        //Then
        assertEquals(expected, actual)
    }

    @Test
    fun `Start Loading`(): Unit = runBlocking {
        //Given
        val expected = true
        //When
        containerViewModel.startLoading()
        //Then
        assertEquals(expected, containerViewModel.containerState.value.loading)
    }

    @Test
    fun `Reset Ui State`(): Unit = runBlocking {
        //Given
        val expected = ""
        //When
        containerViewModel.resetUiState()
        //Then
        assertEquals(expected, containerViewModel.containerState.value.message)
    }
}
