package com.sultandev.feature_category.domain.repository

import com.sultandev.feature_category.data.model.Categories
import com.sultandev.feature_category.data.model.Category
import retrofit2.Response

internal interface CategoryRepository {

    suspend fun getAllCategory(): Response<Categories>

}