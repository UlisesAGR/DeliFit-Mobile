/*
 * RepositoryModule.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.di

import com.delifit.delifitmobile.core.data.repository.ContainerRepositoryImpl
import com.delifit.delifitmobile.core.domain.repository.ContainerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideContainerRepository(containerRepositoryImpl: ContainerRepositoryImpl): ContainerRepository
}
