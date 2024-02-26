/*
 * ContainerDataSource.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.source

import com.delifit.delifitmobile.core.data.db.daos.RecipesDao
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.toDomain
import com.delifit.delifitmobile.core.domain.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContainerDataSource @Inject constructor(
    private val recipesDao: RecipesDao,
) {
    fun clearAndSaveRecipes(recipeList: List<Recipe>) {
        recipesDao.clearAndSaveRecipes(recipeList.map { it.toEntity() })
    }

    fun readRecipes(): Flow<List<Recipe>> =
        recipesDao.readRecipes().map { list ->
            list.map { recipe -> recipe.toDomain() }
        }

    fun readRecipeById(recipeId: Int): Recipe =
        recipesDao.readRecipeById(recipeId).toDomain()
}
