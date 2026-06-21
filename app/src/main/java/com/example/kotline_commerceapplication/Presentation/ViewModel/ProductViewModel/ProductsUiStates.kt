package com.example.kotline_commerceapplication.Presentation.ViewModel.ProductViewModel

import com.example.kotline_commerceapplication.Domain.Models.ProductItem

sealed interface ProductsUiStates {
    data class Success(val products: List<ProductItem>) : ProductsUiStates
    object Error : ProductsUiStates
    object Loading : ProductsUiStates
}