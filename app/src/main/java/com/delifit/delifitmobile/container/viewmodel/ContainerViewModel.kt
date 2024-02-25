/*
 * ContainerViewModel.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.container.viewmodel

import androidx.lifecycle.ViewModel
import com.delifit.delifitmobile.core.domain.usecase.ContainerUseCase
import com.delifit.delifitmobile.core.domain.usecase.IngredientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    private val ingredientsUseCase: IngredientsUseCase,
    private val containerUseCase: ContainerUseCase,
) : ViewModel() {
    private var _containerState = MutableStateFlow(ContainerState())
    val containerState: StateFlow<ContainerState> = _containerState

    init {
        _containerState.update {
            it.copy(
                recipeList = containerUseCase(),
                ingredientsList = ingredientsUseCase(),
            )
        }
    }
}
