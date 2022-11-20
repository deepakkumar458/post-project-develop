package com.demo.interfaces

import com.demo.persistance.entities.ApiResponse
import com.demo.utils.EndPoints.POSTS
import retrofit2.Response
import retrofit2.http.GET

interface DummyApiInterface {

    @GET(POSTS)
    suspend fun getAllEmployees() : Response<List<ApiResponse>>

}