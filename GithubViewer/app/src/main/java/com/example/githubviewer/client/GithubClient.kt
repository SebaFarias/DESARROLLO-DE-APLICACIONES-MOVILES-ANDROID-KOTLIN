package com.example.githubviewer.client

import com.example.githubviewer.service.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubClient {

    companion object
    {
        private val URL_BASE = "https://api.github.com/"

        private val cliente = GithubClient

        fun getCliente() : GithubService
        {
            val retrofit = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(GithubService::class.java)
        }
    }
}