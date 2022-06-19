package com.peter.foody.framework.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peter.foody.R
import com.peter.foody.business.model.Category
import com.peter.foody.databinding.RowCategoryBinding


class CategoriesAdapter(val onCategoryClickListener: OnCategoryClickListener) :
    ListAdapter<Category, CategoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = DataBindingUtil.inflate<RowCategoryBinding>(
            LayoutInflater.from(parent.context), R.layout.row_category, parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onCategoryClickListener.onClick(it1) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

class CategoryViewHolder(private var binding: RowCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(Category: Category) {
        binding.data = Category
        binding.executePendingBindings()
    }
}

class OnCategoryClickListener(val clickListener: (Category: Category) -> Unit) {
    fun onClick(Category: Category) = clickListener(Category)
}