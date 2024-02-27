package com.delifit.delifitmobile.core.utils.mock

import com.delifit.delifitmobile.core.data.network.response.RecipesDataResponse
import com.delifit.delifitmobile.core.data.network.response.RecipesResponse
import com.delifit.delifitmobile.core.data.network.response.StepsResponse
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.utils.Resource
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response

object RecipeMock {
    private val recipeListResponseList: List<RecipesResponse> =
        listOf(
            RecipesResponse(
                id = 0,
                name = "Pizza",
                description = "Good",
                smallDescription = "Good",
                time = "45 min",
                calories = "125 kcal",
                level = "Hard",
                ingredients = listOf("Tomato", "Water"),
                steps = listOf(
                    StepsResponse(
                        number = 1,
                        description = "Shake",
                    ),
                ),
                image = "www.image.com",
                origin = "africa",
                latitude = 25.00,
                longitude = 243.00,
            ),
            RecipesResponse(
                id = 1,
                name = "Hamburger",
                description = "Good",
                smallDescription = "Good",
                time = "12 min",
                calories = "165 kcal",
                level = "Normal",
                ingredients = listOf("Water"),
                steps = listOf(
                    StepsResponse(
                        number = 1,
                        description = "Shake",
                    ),
                ),
                image = "www.image.com",
                origin = "africa",
                latitude = 215.00,
                longitude = 2243.00,
            ),
            RecipesResponse(
                id = 3,
                name = "Taco",
                description = "Good",
                smallDescription = "Good",
                time = "65 min",
                calories = "625 kcal",
                level = "Easy",
                ingredients = listOf("Sugar"),
                steps = listOf(
                    StepsResponse(
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

    val recipeResponse: RecipesResponse =
        RecipesResponse(
            id = 0,
            name = "Pizza",
            description = "Good",
            smallDescription = "Good",
            time = "45 min",
            calories = "125 kcal",
            level = "Hard",
            ingredients = listOf("Tomato", "Water"),
            steps = listOf(
                StepsResponse(
                    number = 1,
                    description = "Shake",
                ),
            ),
            image = "www.image.com",
            origin = "africa",
            latitude = 25.00,
            longitude = 243.00,
        )

    val recipesDataResponse: Response<RecipesDataResponse> =
        Response.success(RecipesDataResponse(recipeListResponseList))

    val recipesResponseSuccess = Resource.Success(recipeList)

    val recipesResponse =
        flowOf(Resource.Success(recipeList))
}
