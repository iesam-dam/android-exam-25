package edu.iesam.androidexam.feature.developers.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.iesam.androidexam.R
import edu.iesam.androidexam.databinding.ItemDevelopersBinding
import edu.iesam.androidexam.feature.developers.domain.Developers
import edu.iesam.androidexam.feature.developers.presentation.DeveloperDiffUtil

class DevelopersAdapter(
    private val onClick: (Developers) -> Unit
) : ListAdapter<Developers, DevelopersAdapter.ViewHolder>(DeveloperDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDevelopersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemDevelopersBinding,
        val onClick: (Developers) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Developers) {
            binding.idName.text = item.name
            binding.idDegree.text = item.academic_degree

            binding.idAvatar.load(item.url_avatar) {
                crossfade(true)
                placeholder(R.mipmap.ic_launcher)
                error(R.mipmap.ic_launcher_round)
            }

            binding.root.setOnClickListener { onClick(item) }
        }
    }
}

