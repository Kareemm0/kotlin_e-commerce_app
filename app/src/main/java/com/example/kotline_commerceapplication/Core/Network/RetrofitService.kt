package com.example.kotline_commerceapplication.Core.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://accessories-eshop.runasp.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}