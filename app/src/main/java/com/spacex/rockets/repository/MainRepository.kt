package com.spacex.rockets.repository

import com.spacex.rockets.networks.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getRocketsList() = apiHelper.getRocketsList()

    suspend fun getRocketsDetail(id: String) = apiHelper.getRocketsDetail(id)
}