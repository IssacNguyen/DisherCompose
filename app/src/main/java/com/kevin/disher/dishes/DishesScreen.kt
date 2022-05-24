package com.kevin.disher.dishes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.kevin.disher.category.SingleItem
import com.kevin.disher.dishes.model.Meal
import com.kevin.disher.dishes.viewmodel.DishesViewModel
import com.kevin.disher.dishes.viewmodel.ViewState

@Composable
fun DishesScreen(
    category: String?,
    viewModel: DishesViewModel = hiltViewModel()
) {

    DisposableEffect(key1 = Unit) {
        if (!category.isNullOrEmpty()) {
            viewModel.getDishesForCategory(category)
        }
        onDispose {}
    }

    val viewState by remember {
        viewModel.viewState
    }

    when (val state = viewState) {
        is ViewState.Loading -> {
            Text(text = "Loading")
        }
        is ViewState.Success -> {
            DishesList(meals = state.data)
        }
        is ViewState.Error -> {
            Text(text = "Error ${state.errorMessage}")
        }
    }
}

@Composable
fun DishesList(meals: List<Meal>) {
    LazyColumn {
        items(meals) { item ->
            SingleItem(title = item.strMeal, thumbnail = item.strMealThumb, onClick = {})
        }
    }
}

