package com.example.rxjavaproject.data.model

data class Location (
    val street: Street? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val postalCode: Int? = null,
    val coordinates: Coordinates? = null,
    val timeZone: TimeZone? = null,

    )