package com.kevin.disher.detail.repository

import com.kevin.disher.detail.model.DetailResponse
import com.kevin.disher.detail.service.IDetailService
import javax.inject.Inject

interface IDetailRepository {
    suspend fun getDetailDishes(mealId: String): DetailResponse
}

class DetailRepository @Inject constructor(private val service: IDetailService) :
    IDetailRepository {
    override suspend fun getDetailDishes(mealId: String): DetailResponse {
        return service.getDetailForDish(mealId)
    }
}