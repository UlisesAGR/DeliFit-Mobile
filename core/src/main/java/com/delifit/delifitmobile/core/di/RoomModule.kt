/*
 * RoomModule.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.core.di

import android.content.Context
import androidx.room.Room
import com.delifit.delifitmobile.core.BuildConfig.DATABASE
import com.delifit.delifitmobile.core.data.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        Database::class.java,
        DATABASE,
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideRecipesDao(db: Database) = db.getRecipesDao()
}
