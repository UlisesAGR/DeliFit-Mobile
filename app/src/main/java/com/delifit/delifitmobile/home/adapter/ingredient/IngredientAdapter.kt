/*
 * OperatorsAdapter.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.ingredient

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Ingredient
import com.delifit.delifitmobile.home.adapter.ingredient.IngredientViewHolder.Companion.selectedItem
import com.delifit.delifitmobile.utils.Constants.EMPTY_STRING
import com.delifit.delifitmobile.widgets.databinding.ItemIngredientBinding

@SuppressLint("NotifyDataSetChanged")
class IngredientAdapter(
    private var ingredientList: List<Ingredient> = emptyList(),
    private val onItemSelected: (String) -> Unit,
) : RecyclerView.Adapter<IngredientViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): IngredientViewHolder =
        IngredientViewHolder(
            ItemIngredientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: IngredientViewHolder,
        position: Int,
    ) {
        holder.render(ingredientList[position], onItemSelected)
    }

    override fun getItemCount(): Int = ingredientList.size

    fun setList(list: List<Ingredient>) {
        ingredientList = list
        notifyDataSetChanged()
    }

    fun dataSetChanged() {
        notifyDataSetChanged()
    }

    fun resetSelectedItem() {
        selectedItem = EMPTY_STRING
    }
}
