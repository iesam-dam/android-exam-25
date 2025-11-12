package edu.iesam.androidexam.feature.androidexam.domain

interface Repository {
    suspend fun findAll(): Result<List<Developers>>
}