package com.peter.foody.business.repositories.implementation

import com.peter.foody.business.fromResponseToModel
import com.peter.foody.business.model.DataModel
import com.peter.foody.business.repositories.abstraction.FoodRepository
import com.peter.foody.framework.datasource.network.FoodAPI
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val api: FoodAPI) : FoodRepository {
    override fun getFood(): Flow<DataModel> = flow {
            emit(api.getFoodAsync().await().fromResponseToModel())
    }.flowOn(IO)
}