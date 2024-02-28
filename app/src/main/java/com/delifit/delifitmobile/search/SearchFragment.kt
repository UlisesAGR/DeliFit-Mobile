/*
 * SearchFragment.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.databinding.FragmentSearchBinding
import com.delifit.delifitmobile.search.adapter.RecipeSearchAdapter
import com.delifit.delifitmobile.utils.Constants.EMPTY_STRING
import com.delifit.delifitmobile.utils.collect
import com.delifit.delifitmobile.utils.hideSoftKeyboard
import com.delifit.delifitmobile.utils.onTetWatcher
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    private val containerViewModel: ContainerViewModel by activityViewModels()

    private lateinit var recipeSearchAdapter: RecipeSearchAdapter

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
        setRecipeSearchAdapter()
        setRecipeSearchRecyclerView()
        setFocusFilter()
        setListeners()
        setFlows()
    }

    private fun setRecipeSearchAdapter() {
        recipeSearchAdapter =
            RecipeSearchAdapter(
                onItemSelected = { recipe ->
                    binding.root.hideSoftKeyboard()
                    findNavController().navigate(
                        SearchFragmentDirections.actionSearchFragmentToDetailFragment(recipe.id),
                    )
                    clearFilter()
                },
            )
    }

    private fun setRecipeSearchRecyclerView() {
        binding.recipeSearchRecyclerView.apply {
            setHasFixedSize(true)
            adapter = recipeSearchAdapter
        }
    }

    private fun setListeners() =
        with(binding) {
            backImageView.setOnSafeClickListener {
                it.hideSoftKeyboard()
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToHomeFragment(),
                )
            }
            nameEditText.onTetWatcher { name ->
                containerViewModel.filterByName(name)
            }
            clearImageView.setOnSafeClickListener {
                clearFilter()
            }
        }

    private fun setFlows() {
        collect(containerViewModel.containerState) { state ->
            recipeSearchAdapter.setList(state.recipeList)
        }
    }

    private fun setFocusFilter() {
        binding.nameEditText.apply {
            requestFocus()
        }
    }

    private fun clearFilter() {
        binding.nameEditText.setText(EMPTY_STRING)
    }
}
