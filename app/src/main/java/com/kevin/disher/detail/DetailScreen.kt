package com.kevin.disher.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.kevin.disher.detail.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    mealId: String?,
    viewModel: DetailViewModel = hiltViewModel()
) {
    DisposableEffect(key1 = Unit) {
        if (!mealId.isNullOrEmpty()) {
            viewModel.getDetailForDish(mealId)
        }
        onDispose {}
    }
    Text(text = "DETAIL SCREEN")
}