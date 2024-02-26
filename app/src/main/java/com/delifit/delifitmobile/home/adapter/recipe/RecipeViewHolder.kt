/*
 * RecipeViewHolder.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.recipe

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.LevelCooking
import com.delifit.delifitmobile.utils.load
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.utils.show
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
            setImage(image)
            setName(name)
            setSmallDescription(smallDescription)
            setTime(time)
            setStatus(level.toLevelCooking())
        }
        root.setOnSafeClickListener {
            onItemSelected(recipe)
        }
    }

    private fun setImage(image: String?) =
        with(binding.foodImageView)
        {
            if (!image.isNullOrEmpty()) {
                load(
                    image,
                    error = R.drawable.ic_error,
                )
                show()
            }
        }

    private fun setName(name: String?) =
        with(binding.nameTextView)
        {
            if (!name.isNullOrEmpty()) {
                text = name
                show()
            }
        }

    private fun setSmallDescription(description: String?) =
        with(binding.smallDescriptionTextView)
        {
            if (!description.isNullOrEmpty()) {
                text = description
                show()
            }
        }

    private fun setTime(time: String?) =
        with(binding.timeTextView)
        {
            if (!time.isNullOrEmpty()) {
                text = time
                show()
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
