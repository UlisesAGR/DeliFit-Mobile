/*
 * LevelCooking.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

enum class LevelCooking {
    EASY,
    NORMAL,
    HARD,
}

fun String.toLevelCooking(): LevelCooking =
    when (this.lowercase()) {
        "easy" -> LevelCooking.EASY
        "normal" -> LevelCooking.NORMAL
        "hard" -> LevelCooking.HARD
        else -> LevelCooking.NORMAL
    }
