package com.kevin.disher.dishes.usecase

import com.kevin.disher.dishes.model.DishesResponse
import com.kevin.disher.dishes.repository.IDishesRepository
import javax.inject.Inject

interface IGetDishesUseCase {
    suspend operator fun invoke(categoryName: String): DishesResponse
}

class GetDishesUseCase @Inject constructor(
    private val repository: IDishesRepository
) : IGetDishesUseCase {
    override suspend fun invoke(categoryName: String): DishesResponse {
        return repository.getDishesForCategory(categoryName)
    }
}