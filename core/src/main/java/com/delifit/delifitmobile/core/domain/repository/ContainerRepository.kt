/*
 * ContainerRepository.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.repository

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe

interface ContainerRepository {
    fun getIngredientsList(): List<Ingredient>

    fun getRecipeList(): List<Recipe>
}
