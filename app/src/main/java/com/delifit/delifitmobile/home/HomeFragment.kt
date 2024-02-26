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
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.databinding.FragmentHomeBinding
import com.delifit.delifitmobile.home.adapter.ingredient.IngredientAdapter
import com.delifit.delifitmobile.home.adapter.recipe.RecipeAdapter
import com.delifit.delifitmobile.utils.collect
import com.delifit.delifitmobile.utils.setOnSafeClickListener
import com.delifit.delifitmobile.widgets.text.dialog.loader.LoaderDialogConfig
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val containerViewModel: ContainerViewModel by viewModels()
    private lateinit var loaderDialogConfig: LoaderDialogConfig
    private lateinit var ingredientsAdapter: IngredientAdapter
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
        openLoaderDialog()
        setIngredientsAdapter()
        setIngredientsRecyclerView()
        setRecipeAdapter()
        setRecipeRecyclerView()
        setListeners()
        setFlows()
    }

    private fun setIngredientsAdapter() {
        ingredientsAdapter =
            IngredientAdapter(
                onItemSelected = { ingredient ->
                    ingredientsAdapter.notifyDataChanged()
                    filterByIngredient(ingredient)
                },
            )
    }

    private fun filterByIngredient(ingredient: String) {
        lifecycleScope.launch {
            recipeAdapter.filterByIngredient(ingredient)
        }
    }

    private fun setIngredientsRecyclerView() {
        binding.ingredientsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = ingredientsAdapter
        }
    }

    private fun setRecipeAdapter() {
        recipeAdapter =
            RecipeAdapter(
                onItemSelected = { recipe ->
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailActivity(recipe.id),
                    )
                },
            )
    }

    private fun setRecipeRecyclerView() {
        binding.recipeRecyclerView.apply {
            setHasFixedSize(true)
            adapter = recipeAdapter
        }
    }

    private fun setListeners() =
        with(binding) {
            searchView.setOnSafeClickListener {
                ingredientsAdapter.resetSelectedItem()
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSearchFragment(),
                )
            }
        }

    private fun setFlows() {
        collect(containerViewModel.containerState) { state ->
            setLoaderVisibility(state.loading)
            ingredientsAdapter.setList(state.ingredientsList)
            recipeAdapter.setList(state.recipeList)
        }
    }

    private fun setLoaderVisibility(loading: Boolean) {
        if (!loading) {
            loaderDialogConfig.dismissLoaderDialog()
        }
    }

    private fun openLoaderDialog() {
        loaderDialogConfig =
            LoaderDialogConfig()
                .also { config ->
                    config.apply {
                        showLoaderDialog(childFragmentManager)
                        setCancelable(false)
                    }
                }
    }
}
