package com.kevin.disher.dishes.repository

import com.kevin.disher.dishes.model.DishesResponse
import com.kevin.disher.dishes.service.IDishesService
import javax.inject.Inject

interface IDishesRepository {
    suspend fun getDishesForCategory(categoryName: String): DishesResponse
}

class DishesRepository @Inject constructor(
    private val service: IDishesService
) : IDishesRepository {

    override suspend fun getDishesForCategory(categoryName: String): DishesResponse {
        return service.getDishesForCategory(categoryName)
    }

}