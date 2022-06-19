package com.peter.foody.business.repositories.abstraction

import com.peter.foody.business.model.DataModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

    fun getFood() : Flow<DataModel>
}