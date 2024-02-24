/*
 * OperatorsAdapter.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.domain.Recipe
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeAdapter(
    private var recipeList: List<Recipe> = emptyList(),
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
    suspend fun setList(list: List<Recipe>) =
        withContext(Dispatchers.Main) {
            recipeList = list
            notifyDataSetChanged()
        }
}