/*
 * ContainerState.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.ui.container.viewmodel

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.Constants.EMPTY_DOUBLE
import com.delifit.delifitmobile.utils.Constants.EMPTY_INT
import com.delifit.delifitmobile.utils.Constants.EMPTY_STRING

data class ContainerState(
    val loading: Boolean = false,
    val message: String = EMPTY_STRING,
    val recipeList: List<Recipe> = emptyList(),
    val ingredientsList: List<Ingredient> = emptyList(),
    val recipe: Recipe? =
        Recipe(
            id = EMPTY_INT,
            name = EMPTY_STRING,
            description = EMPTY_STRING,
            smallDescription = EMPTY_STRING,
            time = EMPTY_STRING,
            calories = EMPTY_STRING,
            level = EMPTY_STRING,
            ingredients = emptyList(),
            steps = emptyList(),
            image = EMPTY_STRING,
            origin = EMPTY_STRING,
            latitude = EMPTY_DOUBLE,
            longitude = EMPTY_DOUBLE,
        ),
)
