package com.kevin.disher.category.service

import com.kevin.disher.category.model.CategoryResponse
import retrofit2.http.GET

//Đây là nơi retrofit sẽ được khai báo

///www.themealdb.com/api/json/v1/1/categories.php
interface ICategoryService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse

}