/*
 * IngredientViewHolder.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.ingredient

import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.utils.Constants.EMPTY_STRING
import com.delifit.delifitmobile.utils.setImageViewAnimation
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.ItemIngredientBinding

class IngredientViewHolder(
    private val binding: ItemIngredientBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private val context = binding.root.context

    fun render(
        ingredient: Ingredient,
        onItemSelected: (String) -> Unit,
    ) = with(binding) {
        ingredient.apply {
            foodImageView.setImageResource(image)
            nameTextView.text = name
        }
        setSelectedIngredient(ingredient.name)
        ingredientMaterialCardView.setOnSafeClickListener {
            selectedItem =
                if (ingredient.name != selectedItem) {
                    ingredient.name
                } else {
                    EMPTY_STRING
                }
            onItemSelected(selectedItem)
        }
    }

    private fun setSelectedIngredient(ingredient: String) =
        with(binding) {
            if (ingredient == selectedItem) {
                foodImageView.setImageViewAnimation(R.anim.up)
                ingredientMaterialCardView.apply {
                    strokeColor = context.getColor(R.color.widgets_card_active)
                    setCardBackgroundColor(context.getColor(R.color.widgets_card_active_transparent))
                }
                nameTextView.setTextColor(context.getColor(R.color.widgets_card_active))
            } else {
                ingredientMaterialCardView.apply {
                    strokeColor = context.getColor(R.color.md_theme_light_outlineVariant)
                    setCardBackgroundColor(context.getColor(R.color.widgets_white))
                }
                nameTextView.setTextColor(context.getColor(R.color.widgets_black))
            }
        }

    companion object {
        var selectedItem: String = ""
    }
}
