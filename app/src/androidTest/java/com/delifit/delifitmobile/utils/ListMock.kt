package com.delifit.delifitmobile.utils

import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.Steps
import kotlinx.coroutines.flow.flowOf

object ListMock {
    val recipeList: List<Recipe> =
        listOf(
            Recipe(
                id = 0,
                name = "Pizza",
                description = "Good",
                smallDescription = "Good",
                time = "45 min",
                calories = "125 kcal",
                level = "Hard",
                ingredients = listOf("Tomato", "Water"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Shake",
                    ),
                ),
                image = "www.image.com",
                origin = "africa",
                latitude = 25.00,
                longitude = 243.00,
            ),
            Recipe(
                id = 1,
                name = "Hamburger",
                description = "Good",
                smallDescription = "Good",
                time = "12 min",
                calories = "165 kcal",
                level = "Normal",
                ingredients = listOf("Water"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Shake",
                    ),
                ),
                image = "www.image.com",
                origin = "africa",
                latitude = 215.00,
                longitude = 2243.00,
            ),
            Recipe(
                id = 3,
                name = "Taco",
                description = "Good",
                smallDescription = "Good",
                time = "65 min",
                calories = "625 kcal",
                level = "Easy",
                ingredients = listOf("Sugar"),
                steps = listOf(
                    Steps(
                        number = 1,
                        description = "Shake",
                    ),
                ),
                image = "www.image.com",
                origin = "africa",
                latitude = 259.00,
                longitude = 2473.00,
            ),
        )

    val ingredientsList: List<Ingredient> =
        listOf(
            Ingredient(
                id = 0,
                name = "Tomato",
                image = 0,
            ),
            Ingredient(
                id = 1,
                name = "Sugar",
                image = 0,
            ),
            Ingredient(
                id = 2,
                name = "Pickle",
                image = 0,
            ),
        )
}
