package com.puresoftware.bottomnavigationappbar.brands

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://velog.io/@haero_kim/%ED%98%B9%EC%8B%9C-%EC%8B%B1%EA%B8%80%ED%86%A4%EC%9D%B4%EC%84%B8%EC%9A%94-%EC%A0%80%EB%8A%94-%EB%B2%99%EA%B8%80%ED%86%A4%EC%9D%B4%EC%97%90%EC%9A%94-%E3%85%8B%E3%85%8B%E3%85%8B
class RetrofitInstance private constructor() {

    companion object{
        private var instance:RetrofitInstance? = null
        private val baseUrl = "http://dev-api.kooru.be/api/v1"
    }

//    private lateinit var instance: ApiService
//
//    private fun getInstance(): ApiService {
//        var retrofit = retrofit2.Retrofit.Builder().baseUrl("http://dev-api.kooru.be/api/v1")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//        val retrofitService: ApiService = retrofit.create(ApiService::class.java)
//        this.instance = retrofitService
//        return instance
//    }

}