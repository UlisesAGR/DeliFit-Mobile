/*
 * RecipeAdapter.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.ui.home.adapter.recipe

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeBinding

class RecipeAdapter(
    private var recipeList: MutableList<Recipe> = mutableListOf(),
    private val onItemSelected: (Recipe) -> Unit,
) : RecyclerView.Adapter<RecipeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecipeViewHolder =
        RecipeViewHolder(
            ItemRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: RecipeViewHolder,
        position: Int,
    ) {
        holder.render(recipeList[position], onItemSelected)
    }

    override fun getItemCount(): Int = recipeList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Recipe>) {
        recipeList = list.toMutableList()
        notifyDataSetChanged()
    }
}
