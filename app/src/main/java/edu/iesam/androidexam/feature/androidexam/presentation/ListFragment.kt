package edu.iesam.androidexam.feature.androidexam.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.androidexam.databinding.ListFragmentBinding
import edu.iesam.androidexam.feature.androidexam.core.api.ApiClient
import edu.iesam.androidexam.feature.androidexam.data.DataRepository
import edu.iesam.androidexam.feature.androidexam.data.remote.api.ApiRemoteDataSource
import edu.iesam.androidexam.feature.androidexam.domain.GetAllDevelopersUseCase

class ListFragment : Fragment() {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel = ListViewModel(
        GetAllDevelopersUseCase(
            DataRepository(
                ApiRemoteDataSource(
                    ApiClient()
                )
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        setUpRecycleView()
        viewModel.loadDevelopers()
    }

    fun setUpObserver(){
        val observer : Observer<UiState>
        //Aqui habría que actualizar el Observer
    }

    fun setUpRecycleView(){
        //Aquí habría que actualizar el recycle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}