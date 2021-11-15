package com.example.razasperros.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.razasperros.model.Raza

@Dao
public interface RazaDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazas ( raza : Raza)

    @Query("SELECT message FROM tabla_razas")
    fun getAllRazas() : Object

}