package edu.iesam.androidexam.feature.developers.data

import edu.iesam.androidexam.feature.developers.data.remote.api.DeveloperApiRemoteDataSource
import edu.iesam.androidexam.feature.developers.domain.Developers
import edu.iesam.androidexam.feature.developers.domain.DevelopersRepository

class DeveloperDataRepository(private val developerApiRemoteDataSource: DeveloperApiRemoteDataSource) :
    DevelopersRepository {
    override suspend fun getDevelopers(): Result<List<Developers>> {
        return developerApiRemoteDataSource.getDevelopers()
    }
}
