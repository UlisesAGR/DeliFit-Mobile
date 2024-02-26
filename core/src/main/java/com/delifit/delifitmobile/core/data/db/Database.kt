/*
 * Database.kt
 * Created by Ulises Gonzalez on 06/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delifit.delifitmobile.core.data.db.daos.RecipesDao
import com.delifit.delifitmobile.core.data.db.entities.RecipeEntity

@Database(
    entities = [RecipeEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class Database : RoomDatabase() {
    abstract fun getRecipesDao(): RecipesDao
}
