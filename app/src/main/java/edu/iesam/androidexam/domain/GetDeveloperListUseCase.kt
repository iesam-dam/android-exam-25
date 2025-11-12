package edu.iesam.androidexam.domain

class GetDeveloperListUseCase(private val repository: DeveloperRepository) {

    operator fun invoke(): List<Developer> {
        return repository.getDeveloperList()
    }
}