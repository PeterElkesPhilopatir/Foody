package com.peter.foody.framework.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.peter.foody.R
import com.peter.foody.databinding.FragmentMainBinding
import com.peter.foody.framework.presentation.adapters.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.offers.observe(viewLifecycleOwner) {
            val adapter = OffersAdapter(onOfferClickListener = OnOfferClickListener {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            })
            binding.offers.adapter = adapter
            adapter.submitList(it)
        }

        viewModel.categories.observe(viewLifecycleOwner) {
            val adapter = CategoriesAdapter(onCategoryClickListener = OnCategoryClickListener {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            })
            binding.categories.adapter = adapter
            adapter.submitList(it)
        }

        viewModel.sliders.observe(viewLifecycleOwner) {
            val adapter = SlidersAdapter(onSliderClickListener = OnSliderClickListener {
                Toast.makeText(context, it.photo, Toast.LENGTH_SHORT).show()
            })
            binding.sliders.adapter = adapter
            adapter.submitList(it)
        }
        return binding.root
    }

}