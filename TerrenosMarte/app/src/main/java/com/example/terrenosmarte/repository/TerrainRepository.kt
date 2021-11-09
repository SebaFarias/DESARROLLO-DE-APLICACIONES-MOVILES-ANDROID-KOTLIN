package com.example.terrenosmarte.repository

import android.util.Log
import android.widget.Toast
import com.example.terrenosmarte.client.TerrainClient
import com.example.terrenosmarte.dao.TerrainDAO
import com.example.terrenosmarte.model.Terrain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TerrainRepository( private val terrainDAO: TerrainDAO) {

    private val service = TerrainClient.getClient()
    val terrainList = terrainDAO.getAllTerrainsFromDB()

    fun getDataFromServer(){
        var call = service.getTerrains()
        call.enqueue( object : Callback<ArrayList<Terrain>>{
            override fun onResponse(call: Call<ArrayList<Terrain>>, response: Response<ArrayList<Terrain>>) {
              response.body().let{
                  CoroutineScope(IO).launch {
                      terrainDAO.insertAllTerrains(it!!)
                  }
              }
            }

            override fun onFailure(call: Call<ArrayList<Terrain>>, t: Throwable) {
                Log.e("TERRAIN_REPO",t.message.toString())
            }

        })
    }



}