package edu.iesam.androidexam.feature.developers.domain


class GetDevelopersUseCase(private val repository: DevelopersRepository) {
    suspend operator fun invoke(): Result<List<Developers>> =
        repository.getDevelopers()
}
