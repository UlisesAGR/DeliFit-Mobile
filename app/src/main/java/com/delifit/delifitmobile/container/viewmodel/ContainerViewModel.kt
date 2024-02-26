/*
 * ContainerViewModel.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.container.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delifit.delifitmobile.core.data.provider.TextsProvider
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.usecase.GetIngredientsListUseCase
import com.delifit.delifitmobile.core.domain.usecase.GetRecipesUseCase
import com.delifit.delifitmobile.utils.parseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    private val getIngredientsListUseCase: GetIngredientsListUseCase,
    private val getRecipesUseCase: GetRecipesUseCase,
    private val textsProvider: TextsProvider,
) : ViewModel() {
    private var _containerState = MutableStateFlow(ContainerState())
    val containerState: StateFlow<ContainerState> = _containerState

    private var recipeListCurrent: List<Recipe> = emptyList()

    fun getRecipesUseCase() =
        viewModelScope.launch {
            startLoading()
            getRecipesUseCase.invoke()
                .catch { exception ->
                    _containerState.update { state ->
                        state.copy(
                            message = exception.parseError().errorMessage,
                        )
                    }
                }
                .collect { response ->
                    if (response.isSuccessful()) {
                        response.data?.let { data ->
                            recipeListCurrent = data
                            _containerState.update { state ->
                                state.copy(
                                    recipeList = data,
                                )
                            }
                        }
                        getIngredientsListUseCase()
                    } else {
                        _containerState.update { state ->
                            state.copy(
                                message = response.message
                                    ?: textsProvider.getErrorGettingRecipesLabel(),
                            )
                        }
                    }
                }
            resetUiState()
        }

    private fun getIngredientsListUseCase() =
        viewModelScope.launch {
            getIngredientsListUseCase.invoke()
                .catch { exception ->
                    _containerState.update { state ->
                        state.copy(
                            message = exception.parseError().errorMessage,
                        )
                    }
                }
                .collect { response ->
                    response.let { data ->
                        _containerState.update { state ->
                            state.copy(
                                loading = false,
                                ingredientsList = data,
                            )
                        }
                    }
                }
            resetUiState()
        }

    fun filterByIngredient(ingredient: String) =
        viewModelScope.launch {
            _containerState.update { state ->
                state.copy(
                    recipeList = recipeListCurrent.filter { recipe ->
                        recipe.ingredients.any { item ->
                            item.lowercase().contains(ingredient.lowercase())
                        }
                    },
                )
            }
        }

    fun filterByName(ingredient: String) =
        viewModelScope.launch {
            _containerState.update { state ->
                state.copy(
                    recipeList = recipeListCurrent.filter { recipe ->
                        recipe.name?.lowercase()?.contains(ingredient.lowercase()) ?: false
                    },
                )
            }
        }

    fun getRecipesById(recipeId: Int) =
        viewModelScope.launch {
            _containerState.update { state ->
                state.copy(
                    recipe = searchRecipe(recipeId),
                )
            }
        }

    private fun searchRecipe(recipeId: Int): Recipe? =
        recipeListCurrent.find { recipe ->
            recipe.id == recipeId
        }

    private fun startLoading() {
        _containerState.update { state ->
            state.copy(
                loading = true,
            )
        }
    }

    private fun resetUiState() {
        _containerState.update {
            it.copy(
                message = "",
            )
        }
    }
}
