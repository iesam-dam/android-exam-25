package edu.iesam.androidexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.androidexam.core.api.ApiClient
import edu.iesam.androidexam.databinding.DevelopersActivityBinding
import edu.iesam.androidexam.feature.developers.data.DeveloperDataRepository
import edu.iesam.androidexam.feature.developers.data.remote.api.DeveloperApiRemoteDataSource
import edu.iesam.androidexam.feature.developers.domain.GetDevelopersUseCase
import edu.iesam.androidexam.feature.developers.presentation.ViewModelDevelopers
import edu.iesam.androidexam.feature.developers.presentation.adapter.DevelopersAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: DevelopersActivityBinding

    private val viewModel: ViewModelDevelopers by lazy {
        ViewModelDevelopers(
            GetDevelopersUseCase(
                DeveloperDataRepository(
                    DeveloperApiRemoteDataSource(ApiClient())
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DevelopersActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupObservers()
        viewModel.loadDevelopers()
    }

    private fun setupView() {
        binding.idDevelopersReciclerView.adapter = DevelopersAdapter {

        }
    }

    private fun setupObservers() {
        val observer = Observer<ViewModelDevelopers.UiState> { uiState ->
            uiState.developers?.let {
                (binding.idDevelopersReciclerView.adapter as DevelopersAdapter).submitList(it)
            }
        }
        viewModel.uiState.observe(this, observer)
    }
}
