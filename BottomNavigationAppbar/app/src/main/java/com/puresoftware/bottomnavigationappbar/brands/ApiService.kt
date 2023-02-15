package com.puresoftware.bottomnavigationappbar.brands

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET()
    fun getMainViewPager()

    @POST()
    fun postMainViewPager()
}

