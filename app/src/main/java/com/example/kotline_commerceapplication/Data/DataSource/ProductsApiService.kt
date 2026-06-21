package com.example.kotline_commerceapplication.Data.DataSource

import com.example.kotline_commerceapplication.Domain.Models.ProductResponse
import retrofit2.Call
import retrofit2.http.GET


interface ProductsApiService {
    @GET("products")
    fun getProducts(): Call<ProductResponse>

}