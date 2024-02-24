/*
 * Recipe.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.domain

data class Recipe(
    var id: Int,
    var name: String,
    var description: String,
    var calories: String,
    var image: Int,
    var latitude: String,
    var longitude: String,
)
