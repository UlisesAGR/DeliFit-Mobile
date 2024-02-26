/*
 * Recipe.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.model

import com.delifit.delifitmobile.core.data.db.entities.RecipeEntity

data class Recipe(
    var id: Int,
    var name: String,
    var description: String,
    var smallDescription: String,
    var time: String,
    var calories: String,
    var level: String,
    var ingredients: List<String>,
    var steps: List<Steps>,
    var image: Int,
    var latitude: String,
    var longitude: String,
)

fun Recipe.toEntity(): RecipeEntity =
    RecipeEntity(
        id,
        name,
        description,
        smallDescription,
        time,
        calories,
        level,
        image,
        latitude,
        longitude,
    )

fun RecipeEntity.toDomain(): Recipe =
    Recipe(
        id,
        name,
        description,
        smallDescription,
        time,
        calories,
        level,
        emptyList(),
        emptyList(),
        image,
        latitude,
        longitude,
    )
