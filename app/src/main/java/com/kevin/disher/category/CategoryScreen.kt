package com.kevin.disher.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.kevin.disher.category.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
    onItemCLick: (String) -> Unit
) {
    //Remember function
    val listOfCategories by remember {
        viewModel.listOfCategories
    }
    LazyColumn {
        items(listOfCategories) { item ->
            SingleItem(title = item.strCategory, thumbnail = item.strCategoryThumb) {
                onItemCLick(it)
            }
        }
    }
}

@Composable
fun SingleItem(
    title: String,
    thumbnail: String,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onClick(title)
            }, elevation = 4.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 10.dp),
                painter = rememberAsyncImagePainter(model = thumbnail),
                contentDescription = null
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }

}