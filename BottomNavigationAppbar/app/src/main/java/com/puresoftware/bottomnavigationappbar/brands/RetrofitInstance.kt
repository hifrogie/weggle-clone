package com.puresoftware.bottomnavigationappbar.brands

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private lateinit var instance: ApiService

    fun retrofit(): ApiService {

        var retrofit = retrofit2.Retrofit.Builder().baseUrl("http://dev-api.kooru.be/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService: ApiService = retrofit.create(ApiService::class.java)
        this.instance = retrofitService
        return instance
    }
}
