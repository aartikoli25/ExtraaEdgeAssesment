package com.spacex.rockets.networks

import com.spacex.rockets.model.detail.RocketDetailResponse
import com.spacex.rockets.model.list.RocketListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("rockets")
    suspend fun getRocketsList(): List<RocketListResponse>

    @GET("rockets/{id}")
    suspend fun getRocketsDetail(@Path("id") id: String): RocketDetailResponse

}