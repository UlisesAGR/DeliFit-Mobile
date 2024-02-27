/*
 * Map.kt
 * Created by Ulises Gonzalez on 27/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import com.delifit.delifitmobile.utils.Constants.DURATION
import com.delifit.delifitmobile.utils.Constants.EMPTY_DOUBLE
import com.delifit.delifitmobile.utils.Constants.EMPTY_STRING
import com.delifit.delifitmobile.utils.Constants.ZOOM
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

fun GoogleMap.setMap(
    origin: String?,
    latitude: Double?,
    longitude: Double?,
) {
    val coordinates =
        LatLng(
            latitude ?: EMPTY_DOUBLE,
            longitude ?: EMPTY_DOUBLE,
        )
    val mark =
        MarkerOptions()
            .position(coordinates)
            .title(origin ?: EMPTY_STRING)
    this.apply {
        addMarker(mark)
        animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, ZOOM),
            DURATION,
            null,
        )
    }
}
