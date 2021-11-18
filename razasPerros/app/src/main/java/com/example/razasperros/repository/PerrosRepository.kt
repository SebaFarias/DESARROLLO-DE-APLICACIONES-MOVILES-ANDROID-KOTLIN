package com.example.razasperros.repository

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.razasperros.client.PerrosClient
import com.example.razasperros.model.Perro
import com.example.razasperros.model.PerrosAPI
import com.example.razasperros.model.Raza
import com.example.razasperros.model.RazasAPI
import com.example.razasperros.room.PerrosDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerrosRepository( private val context : Context )
{
    private val service = PerrosClient.getCliente()
    val pDB : PerrosDB = PerrosDB.getDatabase( context )

    suspend fun insertAllRazas( razas : List<Raza>)
    {
        pDB.razaDao().insertAllRazas( razas )
    }
    fun getAllRazas(): LiveData<List<Raza>>
    {
        return pDB.razaDao().getAllRazas()
    }
    suspend fun insertAllPerros( perros : List<Perro> )
    {
        return pDB.razaDao().insertAllPerros( perros )
    }
    fun getPerrosByRaza( raza : String ) : LiveData<List<Perro>>
    {
        return pDB.razaDao().getPerrosByRaza( raza )
    }
    suspend fun addFav( perro : Perro )
    {
        pDB.razaDao().setFavByImgSrc( perro.img_src, 1)
    }
    suspend fun  noFav( perro : Perro )
    {
        pDB.razaDao().setFavByImgSrc( perro.img_src, 0)
    }
    fun getPerrosFavoritos() : LiveData<List<Perro>>
    {
        return pDB.razaDao().getPerrosFavoritos()
    }
    fun insertRazasFromServer()
    {
        var call = service.getAllRazas()
        call.enqueue( object : Callback<RazasAPI> {
            override fun onResponse(call: Call<RazasAPI>, response: Response<RazasAPI>) {
                response.body().let{
                    var razasObj = it!!.message
                    var razasParaDb : ArrayList<Raza> = arrayListOf()
                    for ( raza in razasObj.keys){
                        var newRaza = Raza(raza)
                        razasParaDb.add( newRaza )
                    }
                    CoroutineScope(IO).launch{
                        pDB.razaDao().insertAllRazas( razasParaDb )
                    }
                }
            }

            override fun onFailure(call: Call<RazasAPI>, t: Throwable) {
                Log.e("GetRazasFromAPI",t.message.toString())
            }
        })
    }
    fun insertPerrosByRaza( raza : String )
    {
        var call = service.getByRaza( raza )
        call.enqueue( object : Callback<PerrosAPI> {
            override fun onResponse(call: Call<PerrosAPI>, response: Response<PerrosAPI>) {
                response.body().let {
                    var listadoImagenes = it!!.message
                    var perrosParaDB : ArrayList<Perro> = arrayListOf()
                    for( img in listadoImagenes ){
                        val newPerro = Perro( img ,raza,false)
                        perrosParaDB.add(newPerro)
                    }
                    CoroutineScope(IO).launch {
                        pDB.razaDao().insertAllPerros( perrosParaDB )
                    }
                }
            }

            override fun onFailure(call: Call<PerrosAPI>, t: Throwable) {
                Log.e("GetPerrosFromAPI",t.message.toString())
            }

        })
    }


}
