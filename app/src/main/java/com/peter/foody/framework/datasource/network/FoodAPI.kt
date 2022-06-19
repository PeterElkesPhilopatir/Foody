package com.peter.foody.framework.datasource.network

import com.peter.foody.framework.datasource.responses.FoodResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FoodAPI {
    @GET("api/branches/homepage")
    fun getFoodAsync(): Deferred<FoodResponse>
}