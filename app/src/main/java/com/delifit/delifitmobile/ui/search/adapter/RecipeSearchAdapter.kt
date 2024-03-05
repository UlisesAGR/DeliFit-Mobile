/*
 * RecipeSearchAdapter.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.ui.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeSearchBinding

class RecipeSearchAdapter(
    private var recipeList: MutableList<Recipe> = mutableListOf(),
    private val onItemSelected: (Recipe) -> Unit,
) : RecyclerView.Adapter<RecipeSearchViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecipeSearchViewHolder =
        RecipeSearchViewHolder(
            ItemRecipeSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: RecipeSearchViewHolder,
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
