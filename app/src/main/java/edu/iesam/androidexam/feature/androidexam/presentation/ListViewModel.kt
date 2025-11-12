package edu.iesam.androidexam.feature.androidexam.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.androidexam.feature.androidexam.domain.Developers
import edu.iesam.androidexam.feature.androidexam.domain.ErrorApp
import edu.iesam.androidexam.feature.androidexam.domain.GetAllDevelopersUseCase
import kotlinx.coroutines.launch

data class UiState(
    val done : List<Developers> = emptyList(),
    val isLoading : Boolean = false,
    val error : ErrorApp? = null
)

class ListViewModel(private val getAllDevelopersUseCase: GetAllDevelopersUseCase ) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadDevelopers(){
        viewModelScope.launch {
            getAllDevelopersUseCase().fold(
                {onSucces(it)},
                {onFailure(it as ErrorApp)}
            )
        }
    }

    fun onSucces(developers: List<Developers>) : List<Developers>{
        Log.d("@devs", developers.toString())
        return developers
    }

    fun onFailure(error: ErrorApp) : ErrorApp{
        Log.d("@devs", error.toString())
        return error
    }
}