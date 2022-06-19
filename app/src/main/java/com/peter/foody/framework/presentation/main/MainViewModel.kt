package com.peter.foody.framework.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peter.foody.business.model.Category
import com.peter.foody.business.model.DataModel
import com.peter.foody.business.model.Offer
import com.peter.foody.business.model.Slider
import com.peter.foody.business.usecases.abstraction.FoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: FoodUseCase) : ViewModel() {
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _sliders = MutableLiveData<List<Slider>>()
    val sliders: LiveData<List<Slider>>
        get() = _sliders

    private val _offers = MutableLiveData<List<Offer>>()
    val offers: LiveData<List<Offer>>
        get() = _offers

    init {
        viewModelScope.launch {
            useCase.getFood().collect {
                _categories.value = it.categories
                _sliders.value = it.sliders
                _offers.value = it.offers
            }
        }
    }
}