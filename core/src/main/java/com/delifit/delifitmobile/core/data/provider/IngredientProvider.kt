/*
 * RecipeProvider.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.widgets.R
import javax.inject.Inject

class IngredientProvider @Inject constructor() {
    fun getIngredients(): List<Ingredient> =
        listOf(
            Ingredient(
                id = 1,
                name = "Queso",
                image = R.drawable.il_chese,
            ),
            Ingredient(
                id = 2,
                name = "Tomate",
                image = R.drawable.il_tomato,
            ),
            Ingredient(
                id = 3,
                name = "Huevo",
                image = R.drawable.il_egg,
            ),
            Ingredient(
                id = 4,
                name = "Lechuga",
                image = R.drawable.il_lettuce,
            ),
        )
}
