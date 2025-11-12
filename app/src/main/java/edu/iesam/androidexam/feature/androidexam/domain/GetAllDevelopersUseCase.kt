package edu.iesam.androidexam.feature.androidexam.domain

class GetAllDevelopersUseCase(private val repository: Repository) {
    suspend operator fun invoke(): Result<List<Developers>>{
        return repository.findAll()
    }
}