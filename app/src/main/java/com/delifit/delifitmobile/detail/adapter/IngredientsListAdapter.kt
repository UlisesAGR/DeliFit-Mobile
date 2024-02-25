/*
 * IngredientsListAdapter.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.widgets.databinding.ItemIngredientListBinding

class IngredientsListAdapter :
    ListAdapter<String, IngredientsListAdapter.ViewHolder>(ORDER_COMPARATOR) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemIngredientListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) = holder.bind(getItem(position))

    class ViewHolder(
        private var binding: ItemIngredientListBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: String) =
            with(binding) {
                ingredientTextView.text = ingredient
            }
    }

    companion object {
        private val ORDER_COMPARATOR =
            object : DiffUtil.ItemCallback<String>() {
                override fun areItemsTheSame(
                    oldItem: String,
                    newItem: String,
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: String,
                    newItem: String,
                ) = oldItem == newItem
            }
    }
}
