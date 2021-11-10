package com.example.terrenosmarte.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.terrenosmarte.client.TerrainClient
import com.example.terrenosmarte.dao.TerrainDAO
import com.example.terrenosmarte.model.Terrain
import com.example.terrenosmarte.room.MarsDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TerrainRepository( private val context: Context) {

    private val service = TerrainClient.getClient()
    val database = MarsDB.getDatabase( context )

    //La vieja confiable
    fun getDataFromServer(){
        var call = service.getTerrains()
        call.enqueue( object : Callback<ArrayList<Terrain>>{
            override fun onResponse(call: Call<ArrayList<Terrain>>, response: Response<ArrayList<Terrain>>) {
              response.body().let{
                  CoroutineScope(IO).launch {
                      database.getTerrainDao().insertAllTerrains(it!!)
                  }
              }
            }

            override fun onFailure(call: Call<ArrayList<Terrain>>, t: Throwable) {
                Log.e("TERRAIN_REPO",t.message.toString())
            }

        })
    }
    fun getListaTerrain() : LiveData<List<Terrain>>
    {
        return database.getTerrainDao().getAllTerrainsFromDB()
    }



}