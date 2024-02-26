/*
 * RecipeViewHolder.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.recipe

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.LevelCooking
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.utils.toLevelCooking
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeBinding

class RecipeViewHolder(
    private val binding: ItemRecipeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private val context = binding.root.context

    fun render(
        recipe: Recipe,
        onItemSelected: (Recipe) -> Unit,
    ) = with(binding) {
        recipe.apply {
            foodImageView.setImageResource(image)
            nameTextView.text = name
            descriptionTextView.text = smallDescription
            timeTextView.text = time
            setStatus(level.toLevelCooking())
        }
        root.setOnSafeClickListener {
            onItemSelected(recipe)
        }
    }

    private fun setStatus(level: LevelCooking) =
        with(binding) {
            context.apply {
                when (level) {
                    LevelCooking.EASY -> {
                        levelImageView.setColorFilter(getColor(R.color.widgets_easy))
                        levelTextView.text = getString(R.string.widgets_easy)
                    }

                    LevelCooking.NORMAL -> {
                        levelImageView.setColorFilter(getColor(R.color.widgets_normal))
                        levelTextView.text = getString(R.string.widgets_normal)
                    }

                    LevelCooking.HARD -> {
                        levelImageView.setColorFilter(getColor(R.color.widgets_hard))
                        levelTextView.text = getString(R.string.widgets_hard)
                    }
                }
            }
        }
}
