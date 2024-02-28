package com.delifit.delifitmobile.utils.mock

import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.utils.Resource
import kotlinx.coroutines.flow.flowOf

object RecipeMock {
    const val recipeName: String = "Pizza"
    const val errorDetail = "Service not working"

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

    val listFilteredRecipes: List<Recipe> =
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
        )

    val recipe: Recipe =
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
        )

    val recipeListResponseSuccess =
        flowOf(Resource.Success(recipeList))

    val recipeListResponseFailure =
        flowOf(getRecipeFailureResult())

    val recipeFailureResultDataNull =
        flowOf(getRecipeFailureResultDataNull())

    private fun getRecipeFailureResult(): Resource<List<Recipe>> =
        Resource.Failure(
            status = 0,
            stringCode = "",
            details = errorDetail,
        )

    private fun getRecipeFailureResultDataNull(): Resource<List<Recipe>> =
        Resource.Failure(
            status = 0,
            stringCode = "",
            details = null,
        )
}
