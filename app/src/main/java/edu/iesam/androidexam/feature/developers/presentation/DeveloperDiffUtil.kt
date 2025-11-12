package edu.iesam.androidexam.feature.developers.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.androidexam.feature.developers.domain.Developers

class DeveloperDiffUtil : DiffUtil.ItemCallback<Developers>() {
    override fun areItemsTheSame(oldItem: Developers, newItem: Developers): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Developers, newItem: Developers): Boolean =
        oldItem == newItem
}
