/*
 * RecipeAdapter.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home.adapter.recipe

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("NotifyDataSetChanged")
class RecipeAdapter(
    private var recipeList: List<Recipe> = mutableListOf(),
    private var filterRecipeList: MutableList<Recipe> = mutableListOf(),
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
        holder.render(filterRecipeList[position], onItemSelected)
    }

    override fun getItemCount(): Int = filterRecipeList.size

    suspend fun setList(list: List<Recipe>) =
        withContext(Dispatchers.Main) {
            recipeList = list
            filterRecipeList = recipeList.toMutableList()
            notifyDataSetChanged()
        }

    suspend fun filterByIngredient(ingredient: String) {
        val newList = recipeList.filter { recipe ->
            recipe.ingredients.any { item ->
                item.lowercase().contains(ingredient.lowercase())
            }
        }
        updateList(newList)
    }

    private suspend fun updateList(items: List<Recipe>) =
        withContext(Dispatchers.Main) {
            filterRecipeList = items.toMutableList()
            notifyDataSetChanged()
        }
}
