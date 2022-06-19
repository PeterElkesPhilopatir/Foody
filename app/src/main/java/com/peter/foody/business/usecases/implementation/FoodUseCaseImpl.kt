package com.peter.foody.business.usecases.implementation

import com.peter.foody.business.model.DataModel
import com.peter.foody.business.repositories.abstraction.FoodRepository
import com.peter.foody.business.usecases.abstraction.FoodUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodUseCaseImpl @Inject constructor(private val repository: FoodRepository) : FoodUseCase {
    override fun getFood(): Flow<DataModel> = repository.getFood()
}