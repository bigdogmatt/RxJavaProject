package com.example.rxjavaproject.data

import com.example.rxjavaproject.data.model.Results

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {
    @GET("/api")
    fun getUsers(@Query("results") numOfUsers: Int)
            : Observable<Results>
}