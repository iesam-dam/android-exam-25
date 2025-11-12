package edu.iesam.androidexam.feature.developers.domain

interface DevelopersRepository {
    suspend fun getDevelopers(): Result<List<Developers>>
}