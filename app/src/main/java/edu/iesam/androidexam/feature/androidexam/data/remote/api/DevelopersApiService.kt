package edu.iesam.androidexam.feature.androidexam.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface DevelopersApiService {

    @GET("developers.json")
    suspend fun getAll(): Response<DevelopersResponse>

}