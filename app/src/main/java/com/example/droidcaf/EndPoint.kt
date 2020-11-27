package com.example.droidcaf

import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("droidcafe")
    fun getProduto():Call<List<Produto>>
}