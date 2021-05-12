package com.imaec.pagingwithcoroutine.model

data class Passenger(
    val data: List<Data>,
    val totalPages: Int,
    val totalPassengers: Int
) {
    data class Data(
        val __v: Int,
        val _id: String,
        val airline: Any,
        val name: String,
        val trips: Int
    )
}