package com.example.kotline_commerceapplication.Presentation.ViewModel.ProductViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotline_commerceapplication.Core.Network.RetrofitService
import com.example.kotline_commerceapplication.Data.DataSource.ProductsApiService
import com.example.kotline_commerceapplication.Domain.Models.ProductItem
import com.example.kotline_commerceapplication.Domain.Models.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel() {
    private val products: ProductsApiService
    var state by mutableStateOf(emptyList<ProductItem>())
    var uiState by mutableStateOf<ProductsUiStates>(
        ProductsUiStates.Loading
    )
        private set
    private lateinit var getProducts: Call<ProductResponse>

    init {
        val retrofit = RetrofitService.retrofit
        products = retrofit.create(ProductsApiService::class.java)
        getProducts()
    }

    fun getProducts() {
        uiState = ProductsUiStates.Loading

        products.getProducts().enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                response.body()?.let {
                    state = it.items
                    uiState = ProductsUiStates.Success(state)
                }
            }

            override fun onFailure(
                call: Call<ProductResponse>,
                t: Throwable
            ) {
                uiState = ProductsUiStates.Error
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        getProducts.cancel()
    }
}