package edu.iesam.androidexam.feature.developers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.androidexam.core.error.ErrorApp
import edu.iesam.androidexam.feature.developers.domain.Developers
import edu.iesam.androidexam.feature.developers.domain.GetDevelopersUseCase
import kotlinx.coroutines.launch

class ViewModelDevelopers(private val getDevelopersUseCase: GetDevelopersUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadDevelopers() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch {
            getDevelopersUseCase().fold(
                onSuccess = { developers ->
                    _uiState.value = UiState(developers = developers)
                },
                onFailure = { error ->
                    _uiState.value = UiState(error = error as? ErrorApp)
                }
            )
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val developers: List<Developers>? = null,
        val error: ErrorApp? = null
    )
}
