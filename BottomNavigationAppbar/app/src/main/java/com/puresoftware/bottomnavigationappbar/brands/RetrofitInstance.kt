package com.puresoftware.bottomnavigationappbar.brands

import retrofit2.converter.gson.GsonConverterFactory

// 추후 싱글톤 패턴으로 개발예정
class RetrofitInstance private constructor() {

    private lateinit var instance: ApiService

    private fun getInstance(): ApiService {
        var retrofit = retrofit2.Retrofit.Builder().baseUrl("http://dev-api.kooru.be/api/v1")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService: ApiService = retrofit.create(ApiService::class.java)
        this.instance = retrofitService
        return instance
    }

}