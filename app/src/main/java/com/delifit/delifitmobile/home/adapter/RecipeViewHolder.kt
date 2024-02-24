/*
 * RecipeViewHolder.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.domain.Recipe
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeBinding

class RecipeViewHolder(
    private val binding: ItemRecipeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun render(
        recipe: Recipe,
        onItemSelected: (Recipe) -> Unit,
    ) = with(binding) {
        recipe.apply {
            foodImageView.setImageResource(image)
            nameTextView.text = name
            caloriesTextView.text = calories
        }
        root.setOnSafeClickListener {
            onItemSelected(recipe)
        }
    }
}
