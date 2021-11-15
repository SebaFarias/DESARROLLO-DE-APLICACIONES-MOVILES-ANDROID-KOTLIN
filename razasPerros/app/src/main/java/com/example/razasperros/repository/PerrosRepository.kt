package com.example.razasperros.repository

import android.app.Application
import android.content.Context
import com.example.razasperros.model.Raza
import com.example.razasperros.room.PerrosDB

class PerrosRepository( context : Context )
{
    val pDB: PerrosDB = PerrosDB.getDB( context )

    suspend fun insertAllRazas(raza: Raza)
    {
        pDB.razaDao().insertAllRazas(raza)
    }

    fun getAllRazas(): Object
    {
        return pDB.razaDao().getAllRazas()
    }

}
