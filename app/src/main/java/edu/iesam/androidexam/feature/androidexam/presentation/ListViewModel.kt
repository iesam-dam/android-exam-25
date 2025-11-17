package edu.iesam.androidexam.feature.androidexam.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.androidexam.feature.androidexam.domain.Developers
import edu.iesam.androidexam.feature.androidexam.domain.ErrorApp
import edu.iesam.androidexam.feature.androidexam.domain.GetAllDevelopersUseCase
import kotlinx.coroutines.launch


class ListViewModel(private val getAllDevelopersUseCase: GetAllDevelopersUseCase ) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadDevelopers(){
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            getAllDevelopersUseCase().fold(
                {onSucces(it)},
                {onFailure(it as ErrorApp)}
            )
        }
    }

    fun onSucces(developers: List<Developers>) {
        _uiState.value = UiState(done = developers)
    }

    fun onFailure(error: ErrorApp) {
        _uiState.value = UiState(error = error)
    }

    data class UiState(
        val done : List<Developers> = emptyList(),
        val isLoading : Boolean = false,
        val error : ErrorApp? = null
    )
}