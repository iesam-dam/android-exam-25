package edu.iesam.androidexam.feature.androidexam.data.remote.api

import edu.iesam.androidexam.feature.androidexam.core.api.ApiClient
import edu.iesam.androidexam.feature.androidexam.domain.ErrorApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class ApiRemoteDataSource(private val apiClient: ApiClient) {

    suspend fun getAll(): Result<List<DeveloperModel>>{
        return withContext(Dispatchers.IO){
            try{
                val apiService = apiClient.createService(DevelopersApiService::class.java)
                val response = apiService.getAll()

                if(response.isSuccessful && response.body() != null){
                    val developers = response.body()!!.developers
                    Result.success(developers)
                } else {
                    Result.failure(ErrorApp.ServerError)
                }
        } catch (e: IOException){
            Result.failure(ErrorApp.InternetError)
        }
        }
    }
}