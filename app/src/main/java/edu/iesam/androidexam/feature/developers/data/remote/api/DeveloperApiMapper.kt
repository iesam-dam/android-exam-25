package edu.iesam.androidexam.feature.developers.data.remote.api

import edu.iesam.androidexam.feature.developers.domain.Developers

fun DeveloperApiModel.toModel(): Developers {
    return Developers(this.id, this.name, this.url_avatar, this.academic_degree)
}