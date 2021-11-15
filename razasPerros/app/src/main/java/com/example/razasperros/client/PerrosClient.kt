package com.example.razasperros.client

import com.example.razasperros.service.PerrosService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PerrosClient {
    companion object{
        private val BASE_URL = "https://dog.ceo/api/"
        private val cliente = PerrosClient

        fun getCliente() : PerrosService{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create( PerrosService::class.java)
        }
    }
}