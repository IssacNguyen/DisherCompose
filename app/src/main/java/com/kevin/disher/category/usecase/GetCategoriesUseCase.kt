package com.kevin.disher.category.usecase

import com.kevin.disher.category.model.CategoryResponse
import com.kevin.disher.category.repository.ICategoryRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): CategoryResponse
}

class GetCategoriesUseCase @Inject constructor(
    private val repo: ICategoryRepository
) : IGetCategoriesUseCase {

    override suspend fun invoke(): CategoryResponse {
        return repo.getAllCategories()
    }
}