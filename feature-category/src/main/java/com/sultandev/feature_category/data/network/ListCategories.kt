package com.sultandev.feature_category.data.network

import com.sultandev.feature_category.data.model.Categories
import com.sultandev.feature_category.data.model.Category
import retrofit2.Response
import retrofit2.http.GET

internal interface ListCategories {

    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getAllCategories(): Response<Categories>

}