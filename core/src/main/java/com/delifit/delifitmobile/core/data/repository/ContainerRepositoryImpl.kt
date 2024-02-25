/*
 * ContainerRepositoryImpl.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.repository

import com.delifit.delifitmobile.core.data.provider.IngredientProvider
import com.delifit.delifitmobile.core.data.provider.RecipeProvider
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import javax.inject.Inject

class ContainerRepositoryImpl @Inject constructor(
    private val ingredientProvider: IngredientProvider,
    private val recipeProvider: RecipeProvider,
) : ContainerRepository {
    override fun getIngredientsList(): List<Ingredient> = ingredientProvider.getIngredients()
    override fun getRecipeList(): List<Recipe> = recipeProvider.getRecipes()
}
