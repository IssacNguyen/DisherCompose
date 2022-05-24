package com.kevin.disher.di

import com.kevin.disher.category.repository.CategoryRepository
import com.kevin.disher.category.repository.ICategoryRepository
import com.kevin.disher.category.service.ICategoryService
import com.kevin.disher.category.usecase.GetCategoriesUseCase
import com.kevin.disher.category.usecase.IGetCategoriesUseCase
import com.kevin.disher.detail.repository.DetailRepository
import com.kevin.disher.detail.repository.IDetailRepository
import com.kevin.disher.detail.service.IDetailService
import com.kevin.disher.detail.usecase.GetDetailUsecase
import com.kevin.disher.detail.usecase.IGetDetailUseCase
import com.kevin.disher.dishes.repository.DishesRepository
import com.kevin.disher.dishes.repository.IDishesRepository
import com.kevin.disher.dishes.service.IDishesService
import com.kevin.disher.dishes.usecase.GetDishesUseCase
import com.kevin.disher.dishes.usecase.IGetDishesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(ScalarsConverterFactory.create()) //Convert response to string
            .addConverterFactory(GsonConverterFactory.create()) // Convert response to Json object
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryServices(retrofit: Retrofit): ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishesServices(retrofit: Retrofit): IDishesService {
        return retrofit.create(IDishesService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailServices(retrofit: Retrofit): IDetailService {
        return retrofit.create(IDetailService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInterface {

        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideCategoryUseCase(useCase: GetCategoriesUseCase): IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideDishesRepository(repo: DishesRepository): IDishesRepository

        @Binds
        @Singleton
        fun provideDishesUseCase(useCase: GetDishesUseCase): IGetDishesUseCase

        @Binds
        @Singleton
        fun provideDetailRepository(repo: DetailRepository): IDetailRepository

        @Binds
        @Singleton
        fun provideDetailUseCase(useCase: GetDetailUsecase): IGetDetailUseCase


    }

}