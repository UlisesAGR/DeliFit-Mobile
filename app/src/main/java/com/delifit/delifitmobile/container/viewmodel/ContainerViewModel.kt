/*
 * ContainerViewModel.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.container.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delifit.delifitmobile.core.data.provider.RecipeProvider
import com.delifit.delifitmobile.core.data.provider.TextsProvider
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.usecase.ClearAndSaveRecipesUseCase
import com.delifit.delifitmobile.core.domain.usecase.GetIngredientsListUseCase
import com.delifit.delifitmobile.core.domain.usecase.ReadRecipeByIdUseCase
import com.delifit.delifitmobile.core.domain.usecase.ReadRecipesUseCase
import com.delifit.delifitmobile.utils.ResponseStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    recipeProvider: RecipeProvider,
    private val clearAndSaveRecipesUseCase: ClearAndSaveRecipesUseCase,
    private val getIngredientsListUseCase: GetIngredientsListUseCase,
    private val readRecipesUseCase: ReadRecipesUseCase,
    private val readRecipeByIdUseCase: ReadRecipeByIdUseCase,
    private val textsProvider: TextsProvider,
) : ViewModel() {
    private var _containerState = MutableStateFlow(ContainerState())
    val containerState: StateFlow<ContainerState> = _containerState

    init {
        clearAndSaveRecipesUseCase(recipeProvider.getRecipes())
    }

    private fun clearAndSaveRecipesUseCase(recipeList: List<Recipe>) =
        viewModelScope.launch {
            clearAndSaveRecipesUseCase.invoke(recipeList)
                .collect { response ->
                    when (response) {
                        is ResponseStatus.Loading ->
                            _containerState.update { state ->
                                state.copy(
                                    loading = true,
                                )
                            }

                        is ResponseStatus.Success -> {
                            _containerState.update { state ->
                                state.copy(
                                    message = textsProvider.getSuccessfullySavedRecipesLabel(),
                                )
                            }
                            getIngredientsListUseCase()
                        }

                        is ResponseStatus.Error ->
                            _containerState.update { state ->
                                state.copy(
                                    message = response.message
                                        ?: textsProvider.getErrorSavingRecipesLabel(),
                                )
                            }
                    }
                }
            resetUiState()
        }

    private fun getIngredientsListUseCase() =
        viewModelScope.launch {
            getIngredientsListUseCase.invoke()
                .collect { response ->
                    when (response) {
                        is ResponseStatus.Loading -> {}
                        is ResponseStatus.Success -> {
                            response.data?.let { data ->
                                _containerState.update { state ->
                                    state.copy(
                                        ingredientsList = data,
                                    )
                                }
                            }
                            readRecipesUseCase()
                        }

                        is ResponseStatus.Error ->
                            _containerState.update { state ->
                                state.copy(
                                    message = response.message
                                        ?: textsProvider.getErrorGettingIngredientsLabel(),
                                )
                            }
                    }
                }
            resetUiState()
        }

    fun readRecipesUseCase() =
        viewModelScope.launch {
            readRecipesUseCase.invoke()
                .collect { response ->
                    when (response) {
                        is ResponseStatus.Loading ->
                            _containerState.update { state ->
                                state.copy(
                                    loading = true,
                                )
                            }

                        is ResponseStatus.Success ->
                            _containerState.update { state ->
                                state.copy(
                                    loading = false,
                                    recipeList = response.data ?: emptyList(),
                                )
                            }

                        is ResponseStatus.Error ->
                            _containerState.update { state ->
                                state.copy(
                                    message = response.message
                                        ?: textsProvider.getErrorGettingRecipeLabel(),
                                )
                            }
                    }
                }
            resetUiState()
        }

    fun readRecipeByIdUseCase(recipeId: Int) =
        viewModelScope.launch {
            readRecipeByIdUseCase.invoke(recipeId)
                .collect { response ->
                    when (response) {
                        is ResponseStatus.Loading -> {}
                        is ResponseStatus.Success -> {
                            response.data?.let { data ->
                                _containerState.update { state ->
                                    state.copy(
                                        recipe = data,
                                    )
                                }
                            }
                        }

                        is ResponseStatus.Error ->
                            _containerState.update { state ->
                                state.copy(
                                    message = response.message
                                        ?: textsProvider.getErrorGettingRecipeByIdLabel(),
                                )
                            }
                    }
                }
            resetUiState()
        }

    private fun resetUiState() {
        _containerState.update {
            it.copy(
                message = "",
            )
        }
    }
}
