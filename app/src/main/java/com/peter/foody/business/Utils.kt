package com.peter.foody.business

import com.peter.foody.business.model.*
import com.peter.foody.framework.datasource.responses.*

fun FoodResponse.fromResponseToModel(): DataModel =
    DataModel(
        categories = this.categories.fromCategoryResponseToModel(),
        offers = this.newoffers.fromOfferResponseToModel(),
        sliders = this.sliders.fromSliderResponseToModel()
    )


fun List<CuisineResponse>.fromCuisineResponseToModel(): List<Cuisine> {
    val list = ArrayList<Cuisine>()
    this.forEach { list.add(Cuisine(name = it.name)) }
    return list
}

fun List<CategoryResponse>.fromCategoryResponseToModel(): List<Category> {
    val list = ArrayList<Category>()
    this.forEach { list.add(Category(name = it.name, photo = it.photo, id = it.id)) }
    return list
}

fun List<OfferResponse>.fromOfferResponseToModel(): List<Offer> {
    val list = ArrayList<Offer>()
    this.forEach {
        list.add(
            Offer(
                name = it.name,
                restaurantID = it.RestauranthId,
                description = it.description,
                cover = it.cover,
                cuisines = it.cuisines.fromCuisineResponseToModel()
            )
        )
    }
    return list
}

fun List<SliderResponse>.fromSliderResponseToModel(): List<Slider> {
    val list = ArrayList<Slider>()
    this.forEach {
        list.add(
            Slider(
                photo = it.photo
            )
        )
    }
    return list
}