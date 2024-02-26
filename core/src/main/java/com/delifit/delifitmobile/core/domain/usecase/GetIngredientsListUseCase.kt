/*
 * GetIngredientsListUseCase.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.domain.usecase

import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import javax.inject.Inject

class GetIngredientsListUseCase @Inject constructor(
    private val containerRepository: ContainerRepository,
) {
    suspend operator fun invoke() = containerRepository.getIngredients()
}
