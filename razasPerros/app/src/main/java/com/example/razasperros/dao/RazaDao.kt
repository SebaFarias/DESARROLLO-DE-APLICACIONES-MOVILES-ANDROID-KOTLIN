package com.example.razasperros.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.razasperros.model.Perro
import com.example.razasperros.model.Raza

@Dao
public interface RazaDao {
    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazas ( razas : List<Raza>)

    @Query("SELECT name FROM tabla_razas")
    fun getAllRazas() : LiveData<List<Raza>>

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllPerros( perros : List<Perro> )

    @Query("SELECT raza, img_src, fav FROM tabla_perros WHERE raza = :raza")
    fun getPerrosByRaza( raza : String ) : LiveData<List<Perro>>

    @Query("UPDATE tabla_perros SET fav = :value WHERE img_src = :img_src")
    suspend fun setFavByImgSrc( img_src : String, value : Int = 1 )

    @Query("SELECT raza, img_src, fav FROM tabla_perros WHERE fav = 1")
    fun getPerrosFavoritos() : LiveData<List<Perro>>
}