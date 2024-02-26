/*
 * ContainerRepository.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.repository

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.ResponseStatus
import kotlinx.coroutines.flow.Flow

interface ContainerRepository {
    suspend fun clearAndSaveRecipes(recipeList: List<Recipe>): Flow<ResponseStatus<Unit>>

    suspend fun getIngredients(): Flow<ResponseStatus<List<Ingredient>>>

    suspend fun readRecipes(): Flow<ResponseStatus<List<Recipe>>>

    suspend fun readRecipeById(recipeId: Int): Flow<ResponseStatus<Recipe>>
}
