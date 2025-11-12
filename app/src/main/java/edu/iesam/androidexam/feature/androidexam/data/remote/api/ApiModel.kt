package edu.iesam.androidexam.feature.androidexam.data.remote.api

import com.google.gson.annotations.SerializedName

data class DeveloperModel (
    val id : Int,
    val name : String,
    @SerializedName("url_avatar")
    val urlAvatar: String,
    @SerializedName("academic_degree")
    val academicDegree: String
)