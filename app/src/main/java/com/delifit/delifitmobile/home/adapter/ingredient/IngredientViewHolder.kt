/*
 * IngredientViewHolder.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.ingredient

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.utils.setImageViewAnimation
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.ItemIngredientBinding

@SuppressLint("NotifyDataSetChanged")
class IngredientViewHolder(
    private val binding: ItemIngredientBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private val context = binding.root.context

    fun render(
        ingredient: Ingredient,
        onItemSelected: (Ingredient?) -> Unit,
    ) = with(binding) {
        ingredient.apply {
            foodImageView.setImageResource(image)
            nameTextView.text = name
        }
        setSelectedIngredient(ingredient)
        ingredientMaterialCardView.setOnSafeClickListener {
            selectedItem = if (ingredient != selectedItem) {
                ingredient
            } else null
            onItemSelected(selectedItem)
        }
    }

    private fun setSelectedIngredient(ingredient: Ingredient) =
        with(binding) {
            context.apply {
                if (ingredient == selectedItem) {
                    ingredientMaterialCardView.strokeColor =
                        getColor(R.color.widgets_card_active)
                    ingredientMaterialCardView.setCardBackgroundColor(getColor(R.color.widgets_card_active_transparent))
                    foodImageView.setImageViewAnimation(R.anim.up)
                    nameTextView.setTextColor(getColor(R.color.widgets_card_active))
                } else {
                    ingredientMaterialCardView.strokeColor =
                        getColor(R.color.md_theme_light_outlineVariant)
                    ingredientMaterialCardView.setCardBackgroundColor(getColor(R.color.widgets_white))
                    nameTextView.setTextColor(getColor(R.color.widgets_black))
                }
            }
        }

    companion object {
        private var selectedItem: Ingredient? = null
    }
}
