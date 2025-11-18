package edu.iesam.androidexam.feature.androidexam.data.remote.api
import edu.iesam.androidexam.feature.androidexam.domain.Developers

fun DeveloperModel.toModel(): Developers {
    return Developers(
        this.id,
        this.name,
        this.urlAvatar,
        this.academicDegree
    )
}