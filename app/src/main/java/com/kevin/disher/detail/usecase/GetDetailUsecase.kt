package com.kevin.disher.detail.usecase

import com.kevin.disher.detail.model.DetailResponse
import com.kevin.disher.detail.repository.IDetailRepository
import javax.inject.Inject

interface IGetDetailUseCase {
    suspend operator fun invoke(mealId: String): DetailResponse
}

class GetDetailUsecase @Inject constructor(
    private val repo: IDetailRepository
) : IGetDetailUseCase {

    override suspend fun invoke(mealId: String): DetailResponse {
        return repo.getDetailDishes(mealId)
    }
}