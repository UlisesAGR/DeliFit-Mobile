/*
 * MapFragment.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.core.domain.model.Recipe
import com.delifit.delifitmobile.databinding.FragmentMapBinding
import com.delifit.delifitmobile.utils.collect
import com.delifit.delifitmobile.utils.setMap
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class MapFragment : Fragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentMapBinding.inflate(layoutInflater)
    }

    private val containerViewModel: ContainerViewModel by activityViewModels()
    private val mapFragmentArgs: MapFragmentArgs by navArgs()

    private lateinit var map: GoogleMap

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
        initMap()
        setListener()
    }

    private fun initMap() {
        (childFragmentManager.findFragmentById(R.id.mapFrameLayout) as SupportMapFragment)
            .getMapAsync { googleMap ->
                map = googleMap
                getData()
            }
    }

    private fun getData() {
        containerViewModel.getRecipesById(mapFragmentArgs.id)
        setFlows()
    }

    private fun setFlows() {
        collect(containerViewModel.containerState) { state ->
            createMarker(state.recipe)
        }
    }

    private fun createMarker(recipe: Recipe?) {
        recipe?.apply {
            map.setMap(
                origin,
                latitude,
                longitude,
            )
        }
    }

    private fun setListener() {
        binding.mapToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
