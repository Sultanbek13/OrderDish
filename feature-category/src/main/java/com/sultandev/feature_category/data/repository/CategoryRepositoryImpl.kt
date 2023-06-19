package com.sultandev.feature_category.data.repository

import com.sultandev.feature_category.data.model.Categories
import com.sultandev.feature_category.data.model.Category
import com.sultandev.feature_category.data.network.ListCategories
import com.sultandev.feature_category.domain.repository.CategoryRepository
import retrofit2.Response

internal class CategoryRepositoryImpl(private val listCategories: ListCategories):
    CategoryRepository {

    override suspend fun getAllCategory(): Response<Categories> = listCategories.getAllCategories()

}