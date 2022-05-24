package com.kevin.disher.dishes.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevin.disher.dishes.model.Meal
import com.kevin.disher.dishes.usecase.IGetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Meal>) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val useCase: IGetDishesUseCase
) : ViewModel() {

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState: MutableState<ViewState> = _viewState

    fun getDishesForCategory(categoryName: String) {
        viewModelScope.launch {
            _viewState.value = ViewState.Loading
            try {
                val listDishes = useCase(categoryName)
                _viewState.value = ViewState.Success(listDishes.meals)
            } catch (e: Exception) {
                Log.d("ISSAC", "EXCEPTION: ${e.message}")
                _viewState.value = ViewState.Error(e.message ?: "Unknown error has occurred")
            }
        }
    }
}