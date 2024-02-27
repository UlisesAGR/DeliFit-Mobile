/*
 * RecipeSearchViewHolder.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.utils.load
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.utils.show
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeSearchBinding

class RecipeSearchViewHolder(
    private val binding: ItemRecipeSearchBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun render(
        recipe: Recipe,
        onItemSelected: (Recipe) -> Unit,
    ) = with(binding) {
        recipe.apply {
            setImage(image)
            setName(name)
            setSmallDescription(smallDescription)
        }
        root.setOnSafeClickListener {
            onItemSelected(recipe)
        }
    }

    private fun setImage(image: String?) =
        with(binding.recipeImageView)
        {
            if (!image.isNullOrEmpty()) {
                load(image, error = R.drawable.ic_error)
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
}
