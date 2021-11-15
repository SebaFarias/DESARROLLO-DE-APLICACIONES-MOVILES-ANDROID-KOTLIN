package com.example.terrenosmarte.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.terrenosmarte.model.Terrain

@Dao
public interface TerrainDAO {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertAllTerrains( terrainList : List<Terrain>)

    @Query("SELECT * FROM terrain_table")
    fun getAllTerrainsFromDB():LiveData<List<Terrain>>

    @Query("SELECT id, img_src, type, price FROM terrain_table WHERE id = :id")
    fun getTerrainById( id : Long ) : LiveData<Terrain>

    @Query("SELECT id, img_src, type, price FROM terrain_table LIMIT 1")
    fun getFirstTerrain() : LiveData<Terrain>
}