/*
 * RecipeSearchAdapter.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.widgets.databinding.ItemRecipeSearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@SuppressLint("NotifyDataSetChanged")
class RecipeSearchAdapter(
    private var recipeList: List<Recipe> = mutableListOf(),
    private var filterRecipeList: MutableList<Recipe> = mutableListOf(),
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
        holder.render(filterRecipeList[position], onItemSelected)
    }

    override fun getItemCount(): Int = filterRecipeList.size

    suspend fun setList(list: List<Recipe>) =
        withContext(Dispatchers.Main) {
            recipeList = list
            filterRecipeList = recipeList.toMutableList()
            notifyDataSetChanged()
        }

    suspend fun filterByName(ingredient: String?) {
        ingredient?.let {
            val newList =
                recipeList.filter { recipe ->
                    recipe.name.lowercase().contains(ingredient.lowercase())
                }
            updateList(newList)
        }
    }

    private suspend fun updateList(items: List<Recipe>) =
        withContext(Dispatchers.Main) {
            filterRecipeList = items.toMutableList()
            notifyDataSetChanged()
        }
}
