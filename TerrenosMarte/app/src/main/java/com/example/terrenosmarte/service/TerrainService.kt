package com.example.terrenosmarte.service

import com.example.terrenosmarte.model.Terrain
import retrofit2.Call
import retrofit2.http.GET

interface TerrainService {

    @GET("realestate")
    fun getTerrains() : Call<ArrayList<Terrain>>
}