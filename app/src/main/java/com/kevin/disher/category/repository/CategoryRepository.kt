package com.kevin.disher.category.repository

import com.kevin.disher.category.model.CategoryResponse
import com.kevin.disher.category.service.ICategoryService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    private val service: ICategoryService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }
}