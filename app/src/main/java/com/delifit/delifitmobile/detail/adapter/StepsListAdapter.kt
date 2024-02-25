/*
 * StepsListAdapter.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.widgets.databinding.ItemStepsListBinding

class StepsListAdapter :
    ListAdapter<Steps, StepsListAdapter.ViewHolder>(ORDER_COMPARATOR) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder =
        ViewHolder(
            ItemStepsListBinding.inflate(
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
        private var binding: ItemStepsListBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(steps: Steps) =
            with(binding) {
                numberTextView.text = steps.number.toString()
                stepTextView.text = steps.description
            }
    }

    companion object {
        private val ORDER_COMPARATOR =
            object : DiffUtil.ItemCallback<Steps>() {
                override fun areItemsTheSame(
                    oldItem: Steps,
                    newItem: Steps,
                ) = oldItem == newItem

                override fun areContentsTheSame(
                    oldItem: Steps,
                    newItem: Steps,
                ) = oldItem == newItem
            }
    }
}
