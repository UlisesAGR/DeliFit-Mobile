/*
 * ContainerRepositoryImpl.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.repository

import com.delifit.delifitmobile.core.data.provider.IngredientProvider
import com.delifit.delifitmobile.core.data.source.ContainerDataSource
import com.delifit.delifitmobile.core.domain.model.toDomain
import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import com.delifit.delifitmobile.utils.ResponseStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContainerRepositoryImpl @Inject constructor(
    private val ingredientProvider: IngredientProvider,
    private val containerDataSource: ContainerDataSource,
    private val dispatcher: CoroutineDispatcher,
) : ContainerRepository {
    override suspend fun getIngredients() =
        flow {
            emit(ResponseStatus.Loading())
            try {
                emit(ResponseStatus.Success(ingredientProvider.getIngredients()))
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)

    override suspend fun getRecipes() =
        flow {
            emit(ResponseStatus.Loading())
            val response = containerDataSource.getRecipes()
            try {
                if (response.isSuccessful) {
                    emit(ResponseStatus.Success(response.body()?.data?.map { it.toDomain() }))
                } else {
                    emit(ResponseStatus.Error(response.message()))
                }
            } catch (ex: Exception) {
                emit(ResponseStatus.Error(ex.message))
            }
        }.flowOn(dispatcher)
}
