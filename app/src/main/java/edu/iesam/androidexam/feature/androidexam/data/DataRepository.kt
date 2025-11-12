package edu.iesam.androidexam.feature.androidexam.data

import edu.iesam.androidexam.feature.androidexam.data.remote.api.ApiRemoteDataSource
import edu.iesam.androidexam.feature.androidexam.data.remote.api.toModel
import edu.iesam.androidexam.feature.androidexam.domain.Developers
import edu.iesam.androidexam.feature.androidexam.domain.Repository

class DataRepository(private val apiRemoteDataSource: ApiRemoteDataSource): Repository {

    override suspend fun findAll(): Result<List<Developers>> {
        return apiRemoteDataSource.getAll().map { apiModelList ->
            apiModelList.map { apiModel ->
                apiModel.toModel()
            }
        }
    }
}