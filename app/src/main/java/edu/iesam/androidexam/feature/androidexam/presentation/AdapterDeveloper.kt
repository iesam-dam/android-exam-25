package edu.iesam.androidexam.feature.androidexam.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.androidexam.databinding.ListFragmentBinding
import edu.iesam.androidexam.feature.androidexam.domain.Developers

class AdapterDeveloper(private var dataSet: List<Developers>) :
    RecyclerView.Adapter<AdapterDeveloper.ViewHolder>() {

    class ViewHolder(private val binding: ListFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterDeveloper.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdapterDeveloper.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun updateList(listDevelopers: List<Developers>) {
        dataSet = listDevelopers
        notifyDataSetChanged()
    }
}


