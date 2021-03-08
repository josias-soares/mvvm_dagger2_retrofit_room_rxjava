package com.example.beer.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.beer.datasource.local.models.BeerEntity

@Dao
interface BeerDAO {
    @Query("SELECT * FROM beer")
    fun getAll(): List<BeerEntity>

    @Insert
    fun save(beerEntity: BeerEntity)

    @Query("DELETE FROM beer")
    fun clear()

    @Query("DELETE FROM beer WHERE id = :id")
    fun deleteById(id: Int)

    @Query("SELECT * FROM beer WHERE id = :id")
    fun getById(id: Int): BeerEntity
}