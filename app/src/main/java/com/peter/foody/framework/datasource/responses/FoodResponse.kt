package com.peter.foody.framework.datasource.responses

data class FoodResponse(
    var categories: List<CategoryResponse>,
    var sliders: List<SliderResponse>,
    var newoffers: List<OfferResponse>
)