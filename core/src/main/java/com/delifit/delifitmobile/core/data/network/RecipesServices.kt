/*
 * RecipesServices.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.network

import com.delifit.delifitmobile.core.BuildConfig.ENDPOINT_RECIPES
import com.delifit.delifitmobile.core.data.network.response.RecipesDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface RecipesServices {
    @GET(ENDPOINT_RECIPES)
    suspend fun getRecipes(): Response<RecipesDataResponse>

}
