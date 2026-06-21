package com.example.kotline_commerceapplication.Domain.Models

data class ProductResponse(
    val items: List<ProductItem>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean
)


data class ProductItem(
    val id: String,
    val productCode: String,
    val name: String,
    val description: String,
    val arabicName: String,
    val arabicDescription: String,
    val coverPictureUrl: String,
    val productPictures: List<String>?,
    val price: Double,
    val stock: Int,
    val weight: Double,
    val color: String,
    val rating: Int,
    val reviewsCount: Int,
    val discountPercentage: Int,
    val sellerId: String,
    val categories: List<String>
)