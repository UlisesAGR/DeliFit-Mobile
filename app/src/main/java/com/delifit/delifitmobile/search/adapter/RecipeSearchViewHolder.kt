/*
 * RecipeSearchViewHolder.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeSearchBinding

class RecipeSearchViewHolder(
    private val binding: ItemRecipeSearchBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun render(
        recipe: Recipe,
        onItemSelected: (Recipe) -> Unit,
    ) = with(binding) {
        recipe.apply {
            recipeImageView.setImageResource(image)
            nameTextView.text = name
            smallDescriptionTextView.text = smallDescription
        }
        root.setOnSafeClickListener {
            onItemSelected(recipe)
        }
    }
}
