/*
 * ContainerDataSource.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.source

import com.delifit.delifitmobile.core.data.network.RecipesServices
import javax.inject.Inject

class ContainerDataSource @Inject constructor(
    private val recipesServices: RecipesServices,
) {
    suspend fun getRecipes() =
        recipesServices.getRecipes()

}
