/*
 * Recipe.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.model

import com.delifit.delifitmobile.utils.LevelCooking

data class Recipe(
    var id: Int,
    var name: String,
    var description: String,
    var smallDescription: String,
    var time: String,
    var calories: String,
    var level: LevelCooking,
    var ingredients: String,
    var steps: String,
    var image: Int,
    var latitude: String,
    var longitude: String,
)
