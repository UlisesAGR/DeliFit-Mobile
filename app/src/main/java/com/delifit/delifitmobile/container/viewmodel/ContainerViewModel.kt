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
import com.delifit.delifitmobile.utils.ResponseStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    private val getIngredientsListUseCase: GetIngredientsListUseCase,
    private val getRecipesUseCase: GetRecipesUseCase,
    private val textsProvider: TextsProvider,
) : ViewModel() {
    private var _containerState = MutableStateFlow(ContainerState())
    val containerState: StateFlow<ContainerState> = _containerState
    private var recipeList: List<Recipe> = emptyList()

    init {
        getRecipesUseCase()
    }

    private fun getRecipesUseCase() =
        viewModelScope.launch {
            getRecipesUseCase.invoke()
                .collect { response ->
                    when (response) {
                        is ResponseStatus.Loading ->
                            _containerState.update { state ->
                                state.copy(
                                    loading = true,
                                )
                            }

                        is ResponseStatus.Success -> {
                            response.data?.let { data ->
                                recipeList = data
                                _containerState.update { state ->
                                    state.copy(
                                        recipeList = data,
                                    )
                                }
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
                                        loading = false,
                                        ingredientsList = data,
                                    )
                                }
                            }
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

    fun getRecipes() =
        viewModelScope.launch {
            _containerState.update { state ->
                state.copy(
                    recipeList = recipeList,
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

    @VisibleForTesting
    private fun searchRecipe(recipeId: Int): Recipe? {
        return recipeList.find { recipe ->
            recipe.id == recipeId
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
