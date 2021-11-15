package com.example.razasperros.service

import com.example.razasperros.model.Raza
import retrofit2.Call
import retrofit2.http.GET

interface PerrosService {

    @GET("breeds/list/all")
    fun getAllRazas() : Call<Raza>
}