package com.peter.foody.framework.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peter.foody.R
import com.peter.foody.business.model.Offer
import com.peter.foody.databinding.RowOffersBinding

class OffersAdapter(val onOfferClickListener: OnOfferClickListener) :
    ListAdapter<Offer, OfferViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = DataBindingUtil.inflate<RowOffersBinding>(
            LayoutInflater.from(parent.context), R.layout.row_offers, parent, false
        )
        return OfferViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onOfferClickListener.onClick(it1) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Offer>() {
        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.restaurantID == newItem.restaurantID
        }
    }
}

class OfferViewHolder(private var binding: RowOffersBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(Offer: Offer) {
        binding.data = Offer
        binding.executePendingBindings()
    }
}

class OnOfferClickListener(val clickListener: (Offer: Offer) -> Unit) {
    fun onClick(Offer: Offer) = clickListener(Offer)
}