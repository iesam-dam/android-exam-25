package edu.iesam.androidexam.feature.androidexam.domain

sealed class ErrorApp : Throwable() {

    object InternetError : ErrorApp()

    object ServerError : ErrorApp()
}