package com.example.beer.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.beer.datasource.local.models.BeerEntity

const val CURRENT_VERSION_DATABASE = 1

@Database(
    entities = [

        BeerEntity::class

    ], version = CURRENT_VERSION_DATABASE
)
abstract class BeerDatabase : RoomDatabase() {
    abstract fun beerDAO(): BeerDAO

    companion object {
        const val DATABASE_NAME: String = "task_db"
    }

}