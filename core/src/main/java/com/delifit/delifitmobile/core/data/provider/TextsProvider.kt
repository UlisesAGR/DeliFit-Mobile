/*
 * ContainerProvider.kt
 * ClinicalDecisions App For Android
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import android.content.Context
import com.delifit.delifitmobile.core.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TextsProvider @Inject constructor(
    @ApplicationContext appContext: Context,
) {
    private val resource = appContext.resources

    fun getSuccessfullySavedRecipesLabel(): String =
        resource.getString(R.string.app_successfully_saved_recipes)

    fun getErrorSavingRecipesLabel(): String =
        resource.getString(R.string.app_error_saving_recipes)

    fun getErrorGettingIngredientsLabel(): String =
        resource.getString(R.string.app_error_getting_ingredients)

    fun getErrorGettingRecipeLabel(): String =
        resource.getString(R.string.app_error_getting_recipe)

    fun getErrorGettingRecipeByIdLabel(): String =
        resource.getString(R.string.app_error_getting_recipe_by_id)
}
