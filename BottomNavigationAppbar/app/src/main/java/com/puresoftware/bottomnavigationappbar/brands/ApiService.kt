package com.puresoftware.bottomnavigationappbar.brands

import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @GET()
    fun getMainViewPager()

    @POST()
    fun postMainViewPager()
}

