/*
 * Steps.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.model

import com.delifit.delifitmobile.core.data.network.response.StepsResponse

data class Steps(
    var number: Int,
    var description: String,
)

fun StepsResponse.toDomain(): Steps =
    Steps(
        number,
        description,
    )
