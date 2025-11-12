package edu.iesam.androidexam.feature.developers.data.remote.api

import retrofit2.Response
import retrofit2.http.GET


interface DeveloperApiService {
    @GET("developers.json")
    suspend fun findAll(): Response<List<DeveloperApiModel>>

}