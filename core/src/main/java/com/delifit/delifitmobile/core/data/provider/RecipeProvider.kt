/*
 * RecipeProvider.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.widgets.R
import javax.inject.Inject

class RecipeProvider @Inject constructor() {
    fun getRecipes(): List<Recipe> =
        listOf(
            Recipe(
                id = 1,
                name = "Tostadas",
                description = "Delisiosa crocante tostada para disfrutar con la familia",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = "Easy",
                ingredients = listOf("Tomato", "Spice", "Onion", "Sugar"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 2,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 3,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                ),
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
            Recipe(
                id = 2,
                name = "Pizza",
                description = "Delisiosa crocante tostada para disfrutar con la familia",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = "Normal",
                ingredients = listOf("Tomato", "Spice", "Onion", "Sugar"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 2,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 3,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                ),
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
            Recipe(
                id = 3,
                name = "Hamburgesa",
                description = "Delisiosa crocante tostada para disfrutar con la familia",
                smallDescription = "Delisiosa crocante tostada",
                time = "45 min",
                calories = "261 kcal",
                level = "Hard",
                ingredients = listOf("Tomato", "Spice", "Onion", "Sugar"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 2,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                    Steps(
                        number = 3,
                        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    ),
                ),
                image = R.drawable.il_food,
                latitude = "1.0.1",
                longitude = "2.0.2",
            ),
        )
}
