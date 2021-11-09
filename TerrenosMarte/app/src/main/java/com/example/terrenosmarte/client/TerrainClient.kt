package com.example.terrenosmarte.client

import com.example.terrenosmarte.service.TerrainService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TerrainClient {
    companion object {
        private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
        private val cliente = TerrainClient

        fun getClient() : TerrainService {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(TerrainService::class.java)
        }
    }
}