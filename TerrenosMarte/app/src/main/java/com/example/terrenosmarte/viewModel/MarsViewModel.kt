package com.example.terrenosmarte.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.repository.TerrainRepository
import com.example.terrenosmarte.room.MarsDB

class MarsViewModel( application: Application) : AndroidViewModel( application ){

    private var repository : TerrainRepository
    var terrainList : LiveData<List<Terrain>>


    init{
        val  terrainDao = MarsDB.getDatabase( application ).getTerrainDao()
        repository = TerrainRepository( terrainDao )
        repository.getDataFromServer()
        terrainList = exposeLiveDataFromDatabase()
    }
    fun exposeLiveDataFromDatabase() : LiveData<List<Terrain>>
    {
        return repository.terrainList
    }

}