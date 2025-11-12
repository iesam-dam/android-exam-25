package edu.iesam.androidexam.feature.developers.data.remote.api

import edu.iesam.androidexam.core.api.ApiClient
import edu.iesam.androidexam.core.error.ErrorApp
import edu.iesam.androidexam.feature.developers.domain.Developers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeveloperApiRemoteDataSource(private val apiClient: ApiClient) {
    suspend fun getDevelopers(): Result<List<Developers>> {

        return withContext(Dispatchers.IO) {

            val apiService = apiClient.createService(DeveloperApiService::class.java)
            val resultDeveloper = apiService.findAll()
            if (resultDeveloper.isSuccessful && resultDeveloper.body() != null) {

                Result.success(resultDeveloper.body()!!.map {
                    it.toModel()
                })
            } else {
                Result.failure(Exception(ErrorApp.ServerErrorApp.toString()))
            }
        }
    }
}
