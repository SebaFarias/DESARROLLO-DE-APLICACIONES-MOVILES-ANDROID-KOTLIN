package com.example.githubviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubviewer.client.GithubClient
import retrofit2.Callback
import com.example.githubviewer.model.Repo
import com.example.githubviewer.model.User
import retrofit2.Call
import retrofit2.Response
import java.util.*

class UserViewModel : ViewModel() {

    private val service = GithubClient.getCliente()
    val user = MutableLiveData<User>()
    val repos = MutableLiveData<Repo>()

    fun buscarUser( loginName : String )
    {
        val call = service.getUser( loginName )
        call.enqueue( object :  Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body().let {
                    user.postValue(it)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                call.cancel()
            }

        })
    }

}