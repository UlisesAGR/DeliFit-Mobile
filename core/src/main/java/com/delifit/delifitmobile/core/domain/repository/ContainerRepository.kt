/*
 * ContainerRepository.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.repository

import com.delifit.delifitmobile.core.data.network.utils.Resource
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface ContainerRepository {
    suspend fun getIngredients(): Flow<List<Ingredient>>

    suspend fun getRecipes(): Flow<Resource<List<Recipe>>>
}
