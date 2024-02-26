/*
 * Recipe.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.model

import com.delifit.delifitmobile.core.data.network.response.RecipesResponse

data class Recipe(
    var id: Int,
    var name: String?,
    var description: String?,
    var smallDescription: String?,
    var time: String?,
    var calories: String?,
    var level: String?,
    var ingredients: List<String>,
    var steps: List<Steps>,
    var image: String?,
    var latitude: String?,
    var longitude: String?,
)

fun RecipesResponse.toDomain(): Recipe =
    Recipe(
        id,
        name,
        description,
        smallDescription,
        time,
        calories,
        level,
        ingredients,
        steps.map { it.toDomain() },
        image,
        latitude,
        longitude,
    )
