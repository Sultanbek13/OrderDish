package com.sultandev.feature_category.presentation.viewmodel

import com.sultandev.feature_category.data.model.Category
import kotlinx.coroutines.flow.SharedFlow

internal interface CategoryViewModel {

    val allCategories: SharedFlow<List<Category>>

    val message: SharedFlow<String>

    fun getAllCategories()

}