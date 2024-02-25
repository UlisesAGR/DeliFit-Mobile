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
import com.delifit.delifitmobile.widgets.databinding.ItemIngredientBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("NotifyDataSetChanged")
class IngredientAdapter(
    private var ingredientList: List<Ingredient> = emptyList(),
    private val onItemSelected: (Ingredient?) -> Unit,
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

    suspend fun setList(list: List<Ingredient>) =
        withContext(Dispatchers.Main) {
            ingredientList = list
            notifyDataSetChanged()
        }

    fun notifyDataChanged() {
        notifyDataSetChanged()
    }
}
