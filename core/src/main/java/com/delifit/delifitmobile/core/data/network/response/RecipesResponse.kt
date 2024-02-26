/*
 * RecipesResponse.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.network.response

data class RecipesResponse(
    var id: Int,
    var name: String?,
    var description: String?,
    var smallDescription: String?,
    var time: String?,
    var calories: String?,
    var level: String?,
    var ingredients: List<String>,
    var steps: List<StepsResponse>,
    var image: String?,
    var latitude: String?,
    var longitude: String?,
)
