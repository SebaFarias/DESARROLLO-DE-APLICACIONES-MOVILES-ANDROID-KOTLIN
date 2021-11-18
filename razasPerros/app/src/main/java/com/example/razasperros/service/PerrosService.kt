package com.example.razasperros.service

import com.example.razasperros.model.PerrosAPI
import com.example.razasperros.model.Raza
import com.example.razasperros.model.RazasAPI
import retrofit2.Call
import retrofit2.http.GET

interface PerrosService {

    @GET("breeds/list/all")
    fun getAllRazas() : Call<RazasAPI>

    @GET("breed/{raza}/images")
    fun getByRaza( raza : String ) : Call<PerrosAPI>
}