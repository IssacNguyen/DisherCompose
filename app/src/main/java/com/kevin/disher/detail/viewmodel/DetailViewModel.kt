package com.kevin.disher.detail.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevin.disher.detail.model.Meal
import com.kevin.disher.detail.usecase.IGetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Meal>) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val usecase: IGetDetailUseCase
) : ViewModel() {

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState: MutableState<ViewState> = _viewState

    fun getDetailForDish(mealId: String) {
        viewModelScope.launch {
            _viewState.value = ViewState.Loading
            try {
                val listDetail = usecase(mealId)
                Log.d("ISSAC", "${listDetail.meals}")
                _viewState.value = ViewState.Success(listDetail.meals)
            } catch (e: Exception) {
                _viewState.value = ViewState.Error(e.message ?: "Unknown error has occurred")
            }
        }
    }
}