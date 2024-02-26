/*
 * ContainerRepositoryImpl.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.repository

import com.delifit.delifitmobile.core.data.provider.IngredientProvider
import com.delifit.delifitmobile.core.data.source.ContainerDataSource
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import com.delifit.delifitmobile.utils.ResponseStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContainerRepositoryImpl @Inject constructor(
    private val ingredientProvider: IngredientProvider,
    private val containerDataSource: ContainerDataSource,
    private val dispatcher: CoroutineDispatcher,
) : ContainerRepository {
    override suspend fun clearAndSaveRecipes(recipeList: List<Recipe>) =
        flow {
            emit(ResponseStatus.Loading())
            try {
                emit(ResponseStatus.Success(containerDataSource.clearAndSaveRecipes(recipeList)))
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)

    override suspend fun getIngredients() =
        flow {
            emit(ResponseStatus.Loading())
            try {
                emit(ResponseStatus.Success(ingredientProvider.getIngredients()))
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)

    override suspend fun readRecipes() =
        flow {
            emit(ResponseStatus.Loading())
            try {
                emit(ResponseStatus.Success(containerDataSource.readRecipes().first()))
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)

    override suspend fun readRecipeById(recipeId: Int) =
        flow {
            emit(ResponseStatus.Loading())
            try {
                emit(ResponseStatus.Success(containerDataSource.readRecipeById(recipeId)))
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)
}
