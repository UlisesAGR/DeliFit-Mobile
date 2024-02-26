/*
 * ContainerProvider.kt
 * ClinicalDecisions App For Android
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.provider

import android.content.Context
import com.delifit.delifitmobile.widgets.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TextsProvider @Inject constructor(
    @ApplicationContext appContext: Context,
) {
    private val resource = appContext.resources

    fun getErrorGettingRecipesLabel(): String =
        resource.getString(R.string.widgets_error_getting_recipes)
}
