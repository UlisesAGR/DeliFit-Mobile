/*
 * ContainerState.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.container.viewmodel

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe

data class ContainerState(
    val message: String = "",
    val recipeList: List<Recipe> = emptyList(),
    val ingredientsList: List<Ingredient> = emptyList(),
)
