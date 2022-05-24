package com.kevin.disher.detail.service

import com.kevin.disher.detail.model.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDetailService {
    @GET("lookup.php")
    suspend fun getDetailForDish(@Query(value = "i") mealId: String): DetailResponse
}