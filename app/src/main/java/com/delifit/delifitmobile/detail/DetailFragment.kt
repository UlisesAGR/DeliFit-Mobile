/*
 * DetailFragment.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.databinding.FragmentDetailBinding
import com.delifit.delifitmobile.detail.adapter.IngredientsListAdapter
import com.delifit.delifitmobile.detail.adapter.StepsListAdapter
import com.delifit.delifitmobile.utils.collect
import com.delifit.delifitmobile.utils.load
import com.delifit.delifitmobile.widgets.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private val containerViewModel: ContainerViewModel by activityViewModels()
    private val detailArgs: DetailFragmentArgs by navArgs()

    private lateinit var ingredientsListAdapter: IngredientsListAdapter
    private lateinit var stepsListAdapter: StepsListAdapter

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
        ingredientsListAdapter = IngredientsListAdapter()
        setIngredientsListRecyclerView()
        stepsListAdapter = StepsListAdapter()
        setStepsListRecyclerView()
        containerViewModel.getRecipesById(detailArgs.id)
        setListeners()
        setFlows()
    }

    private fun setIngredientsListRecyclerView() {
        binding.ingredientsListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = ingredientsListAdapter
        }
    }

    private fun setStepsListRecyclerView() {
        binding.stepsListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = stepsListAdapter
        }
    }

    private fun setFlows() {
        collect(containerViewModel.containerState) { state ->
            setDataToView(state.recipe)
        }
    }

    private fun setDataToView(state: Recipe?) {
        state?.let {
            state.apply {
                setImage(image)
                setName(name)
                setSmallDescription(smallDescription)
                setTime(time)
                setCalories(calories)
                setLevel(level)
                setDescription(description)
                setIngredientsList(ingredients)
                setStepsList(steps)
            }
        } ?: run {
            findNavController().popBackStack()
        }
    }

    private fun setImage(image: String) {
        binding.recipeImageView.load(
            image,
            error = R.drawable.ic_error,
        )
    }

    private fun setName(name: String) {
        binding.nameTextView.text = name
    }

    private fun setSmallDescription(smallDescription: String) {
        binding.smallDescriptionTextView.text = smallDescription
    }

    private fun setTime(time: String) {
        binding.timeCardElement.setText(time)
    }

    private fun setCalories(calories: String) {
        binding.caloriesCardElement.setText(calories)
    }

    private fun setLevel(level: String) {
        binding.levelCardElement.setText(level)
    }

    private fun setDescription(description: String) {
        binding.descriptionTextView.text = description
    }

    private fun setStepsList(steps: List<Steps>) {
        stepsListAdapter.submitList(steps)
    }

    private fun setIngredientsList(ingredients: List<String>) {
        ingredientsListAdapter.submitList(ingredients)
    }

    private fun setListeners() =
        with(binding) {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
}
