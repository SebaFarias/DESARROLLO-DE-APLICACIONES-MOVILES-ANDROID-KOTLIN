package com.example.razasperros.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.razasperros.model.Perro
import com.example.razasperros.model.Raza
import com.example.razasperros.repository.PerrosRepository

class PerroViewModel( application: Application ) : AndroidViewModel ( application ) {

    private var repo : PerrosRepository = PerrosRepository( application )
    var razasList : LiveData<List<Raza>> = exposeRazasFromDB()
    var listaPerros : LiveData<List<Perro>> = liveData { listOf<Perro>() }

    fun exposeRazasFromDB() : LiveData<List<Raza>>
    {
        return repo.getAllRazas()
    }
    fun exposePerrosFromDB( raza : String ) : LiveData<List<Perro>>
    {
        return repo.getPerrosByRaza( raza )
    }
    fun exposePerrosFavoritosFromDB() : LiveData<List<Perro>>
    {
        return repo.getPerrosFavoritos()
    }
    suspend fun addFavorite( perro : Perro )
    {
        repo.addFav( perro )
    }
    suspend fun noFav( perro : Perro )
    {
        repo.noFav( perro )
    }
    fun fetchRazasFromServer()
    {
        repo.insertRazasFromServer()
    }
    fun fetchPerrosByRaza( raza : String )
    {
        repo.insertPerrosByRaza( raza )
    }
}