/*
 * RecipeProvider.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import android.content.Context
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.widgets.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class IngredientProvider @Inject constructor(
    @ApplicationContext appContext: Context,
) {
    private val resource = appContext.resources

    fun getIngredients(): List<Ingredient> =
        listOf(
            Ingredient(
                id = 1,
                name = resource.getString(R.string.widgets_cheese),
                image = R.drawable.il_chese,
            ),
            Ingredient(
                id = 2,
                name = resource.getString(R.string.widgets_tomato),
                image = R.drawable.il_tomato,
            ),
            Ingredient(
                id = 3,
                name = resource.getString(R.string.widgets_egg),
                image = R.drawable.il_egg,
            ),
            Ingredient(
                id = 4,
                name = resource.getString(R.string.widgets_lettuce),
                image = R.drawable.il_lettuce,
            ),
        )
}
