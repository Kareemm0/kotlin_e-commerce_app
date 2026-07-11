package com.example.kotline_commerceapplication.Domain.Models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterModel(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
