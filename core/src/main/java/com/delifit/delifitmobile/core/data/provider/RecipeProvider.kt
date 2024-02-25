/*
 * RecipeProvider.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.LevelCooking
import com.delifit.delifitmobile.widgets.R
import javax.inject.Inject

class RecipeProvider @Inject constructor() {
    fun getRecipes(): List<Recipe> =
        listOf(
            Recipe(
                id = 1,
                name = "Tostadas",
                description = "Delisiosa crocante tostada",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = LevelCooking.EASY,
                ingredients = "Papas",
                steps = "1 - Licuar",
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
            Recipe(
                id = 2,
                name = "Tostadas",
                description = "Delisiosa crocante tostada",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = LevelCooking.NORMAL,
                ingredients = "Papas",
                steps = "1 - Licuar",
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
            Recipe(
                id = 3,
                name = "Tostadas",
                description = "Delisiosa crocante tostada",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = LevelCooking.HARD,
                ingredients = "Papas",
                steps = "1 - Licuar",
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
            Recipe(
                id = 4,
                name = "Tostadas",
                description = "Delisiosa crocante tostada",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = LevelCooking.HARD,
                ingredients = "Papas",
                steps = "1 - Licuar",
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
        )
}
