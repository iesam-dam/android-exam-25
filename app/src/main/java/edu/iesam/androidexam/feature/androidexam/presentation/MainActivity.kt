package edu.iesam.androidexam.feature.androidexam.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.androidexam.databinding.ActivityMainBinding
import edu.iesam.androidexam.feature.androidexam.core.api.ApiClient
import edu.iesam.androidexam.feature.androidexam.data.DataRepository
import edu.iesam.androidexam.feature.androidexam.data.remote.api.ApiRemoteDataSource
import edu.iesam.androidexam.feature.androidexam.domain.GetAllDevelopersUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //Lo instancio para probar con break points
        val viewModel = ListViewModel(
            GetAllDevelopersUseCase(
                DataRepository(
                    ApiRemoteDataSource(
                        ApiClient()
                    )
                )
            )
        )

        viewModel.loadDevelopers()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}