package com.delifit.delifitmobile.core.utils.mock

import com.delifit.delifitmobile.core.data.network.response.StepsResponse
import com.delifit.delifitmobile.core.domain.model.Steps

object StepsMock {
    val steps: Steps =
        Steps(
            number = 1,
            description = "Good",
        )

    val stepsResponse: StepsResponse =
        StepsResponse(
            number = 1,
            description = "Good",
        )
}
