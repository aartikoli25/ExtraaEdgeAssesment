package com.spacex.rockets.networks

class ApiHelper(private val apiService: ApiService) {

    suspend fun getRocketsList() = apiService.getRocketsList()

    suspend fun getRocketsDetail(id: String) = apiService.getRocketsDetail(id)
}