package edu.iesam.androidexam.feature.androidexam.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.androidexam.databinding.ListFragmentBinding
import edu.iesam.androidexam.feature.androidexam.core.api.ApiClient
import edu.iesam.androidexam.feature.androidexam.data.DataRepository
import edu.iesam.androidexam.feature.androidexam.data.remote.api.ApiRemoteDataSource
import edu.iesam.androidexam.feature.androidexam.domain.GetAllDevelopersUseCase

class ListFragment : Fragment() {
    private var _binding: ListFragmentBinding? = null
    private val adapter = AdapterDeveloper(emptyList())
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
        setUpObserver()
        viewModel.loadDevelopers()
    }

    fun setUpObserver(){
        val observer = Observer<ListViewModel> { uiState ->

        }
    }

    fun setUpRecycleView(){
        val recyclerView : RecyclerView = binding.list
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}