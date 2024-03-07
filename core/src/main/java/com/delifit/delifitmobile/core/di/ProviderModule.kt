/*
 * RepositoryModule.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.di

import com.delifit.delifitmobile.core.data.provider.IngredientProviderImpl
import com.delifit.delifitmobile.core.data.provider.ResourceProviderImpl
import com.delifit.delifitmobile.core.domain.provider.IngredientProvider
import com.delifit.delifitmobile.core.domain.provider.ResourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderModule {

    @Singleton
    @Binds
    abstract fun provideIngredientProvider(ingredientProviderImpl: IngredientProviderImpl): IngredientProvider

    @Singleton
    @Binds
    abstract fun provideContainerResourceProvider(containerResourceProviderImpl: ResourceProviderImpl): ResourceProvider
}
