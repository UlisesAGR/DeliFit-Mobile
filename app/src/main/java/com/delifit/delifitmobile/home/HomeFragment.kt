/*
 * HomeFragment.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.delifit.delifitmobile.data.provider.RecipeProvider
import com.delifit.delifitmobile.databinding.FragmentHomeBinding
import com.delifit.delifitmobile.home.adapter.RecipeAdapter
import com.delifit.delifitmobile.utils.toast
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setInitUi()
    }

    private fun setInitUi() {
        setAdapter()
        setRecyclerView()
        setAdapterList()
    }

    private fun setAdapter() {
        recipeAdapter =
            RecipeAdapter(
                onItemSelected = { recipe ->
                    requireContext().toast(recipe.name)
                },
            )
    }

    private fun setRecyclerView() {
        binding.homeRecyclerView.apply {
            setHasFixedSize(true)
            adapter = recipeAdapter
        }
    }

    private fun setAdapterList() {
        lifecycleScope.launch {
            recipeAdapter.setList(RecipeProvider.recipe)
        }
    }
}
