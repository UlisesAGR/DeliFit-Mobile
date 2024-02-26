/*
 * SaveRecipesUseCase.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.usecase

import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import javax.inject.Inject

class ClearAndSaveRecipesUseCase @Inject constructor(
    private val containerRepository: ContainerRepository,
) {
    suspend operator fun invoke(recipeList: List<Recipe>) =
        containerRepository.clearAndSaveRecipes(recipeList)
}
