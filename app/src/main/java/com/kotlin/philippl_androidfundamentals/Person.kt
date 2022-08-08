package com.kotlin.philippl_androidfundamentals

import java.io.Serializable

data class Person(
    val firstName: String,
    val lastName: String,
    val email: String,
    val gender: String
) : Serializable
