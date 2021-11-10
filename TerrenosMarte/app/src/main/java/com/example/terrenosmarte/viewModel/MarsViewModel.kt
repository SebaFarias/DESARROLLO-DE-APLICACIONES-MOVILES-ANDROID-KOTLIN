package com.example.terrenosmarte.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.repository.TerrainRepository

class MarsViewModel( application: Application) : AndroidViewModel( application ){

    private var repository : TerrainRepository = TerrainRepository( application.applicationContext )
    var terrainList : LiveData<List<Terrain>> = exposeLiveDataFromDatabase()

    fun getDataFromServer(){
        repository.getDataFromServer()
    }
    fun exposeLiveDataFromDatabase() : LiveData<List<Terrain>>
    {
        return repository.getListaTerrain()
    }

}