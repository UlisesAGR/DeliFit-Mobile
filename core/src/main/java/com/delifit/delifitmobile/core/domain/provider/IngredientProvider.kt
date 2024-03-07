/*
 * IngredientProvider.kt
 * Created by Ulises Gonzalez on 07/03/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.provider

import com.delifit.delifitmobile.core.domain.model.Ingredient

interface IngredientProvider {
    fun getIngredients(): List<Ingredient>
}
