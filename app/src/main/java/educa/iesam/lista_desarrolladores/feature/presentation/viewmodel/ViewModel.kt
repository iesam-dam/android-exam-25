package educa.iesam.lista_desarrolladores.feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import educa.iesam.lista_desarrolladores.feature.domain.ObtenerRegistros
import educa.iesam.lista_desarrolladores.feature.domain.model.Desarrolladores

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModel(private val obtenerRegistros: ObtenerRegistros) : ViewModel() {

}