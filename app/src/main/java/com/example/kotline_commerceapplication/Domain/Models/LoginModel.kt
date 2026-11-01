package com.example.kotline_commerceapplication.Domain.Models

import com.google.gson.annotations.SerializedName


data class LoginModel(
    @SerializedName("accessToken")
    val accessToken: String,

    @SerializedName("expiresAtUtc")
    val expiresAtUtc: String,

    @SerializedName("refreshToken")
    val refreshToken: String
)