package com.delifit.delifitmobile.core.utils.mock

import com.delifit.delifitmobile.core.domain.model.Ingredient
import kotlinx.coroutines.flow.flowOf

object IngredientMock {
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

    val ingredientsListResponse = flowOf(ingredientsList)
}
