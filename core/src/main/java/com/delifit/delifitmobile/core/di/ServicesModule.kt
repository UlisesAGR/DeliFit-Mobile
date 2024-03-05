/*
 * ServicesModule.kt
 * Created by Ulises Gonzalez on 05/03/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.core.di

import com.delifit.delifitmobile.core.data.network.service.RecipesServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {
    @Provides
    fun provideRecipesServices(retrofit: Retrofit): RecipesServices =
        retrofit.create(RecipesServices::class.java)
}