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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delifit.delifitmobile.core.domain.model.Steps
import com.delifit.delifitmobile.databinding.FragmentDetailBinding
import com.delifit.delifitmobile.detail.adapter.IngredientsListAdapter
import com.delifit.delifitmobile.detail.adapter.StepsListAdapter

class DetailFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private val detailArgs: DetailFragmentArgs by navArgs()
    private lateinit var ingredientsListAdapter: IngredientsListAdapter
    private lateinit var stepsListAdapter: StepsListAdapter

    private val ingredients = mutableListOf("Tomato", "Onion", "Sugar")
    private val steps = mutableListOf(
        Steps(
            number = 1,
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
        ),
        Steps(
            number = 2,
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
        ),
        Steps(
            number = 3,
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
        ),
    )

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
        setDataToView()
        setListeners()
    }

    private fun setDataToView() {
        setName()
        setSmallDescription()
        setTime()
        setCalories()
        setLevel()
        setDescription()
        setIngredientsList(ingredients)
        setStepsList(steps)
    }

    private fun setName() {
        binding.nameTextView.text = "Tostadas"
    }

    private fun setSmallDescription() {
        binding.smallDescriptionTextView.text = "Delisiosa crocante tostada"
    }

    private fun setTime() {
        binding.timeCardElement.setText("45 min")
    }

    private fun setCalories() {
        binding.caloriesCardElement.setText("239 kcal")
    }

    private fun setLevel() {
        binding.levelCardElement.setText("Easy")
    }

    private fun setDescription() {
        binding.descriptionTextView.text =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."
    }

    private fun setIngredientsListRecyclerView() {
        binding.ingredientsListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = ingredientsListAdapter
        }
    }

    private fun setIngredientsList(ingredients: MutableList<String>) {
        ingredientsListAdapter.submitList(ingredients)
    }

    private fun setStepsListRecyclerView() {
        binding.stepsListRecyclerView.apply {
            setHasFixedSize(true)
            adapter = stepsListAdapter
        }
    }

    private fun setStepsList(steps: MutableList<Steps>) {
        stepsListAdapter.submitList(steps)
    }

    private fun setListeners() =
        with(binding) {
            toolbar.setNavigationOnClickListener {
                findNavController().navigate(
                    DetailFragmentDirections.actionDetailFragmentToHomeFragment(),
                )
            }
            backButton.setOnClickListener {
                findNavController().navigate(
                    DetailFragmentDirections.actionDetailFragmentToHomeFragment(),
                )
            }
        }
}
