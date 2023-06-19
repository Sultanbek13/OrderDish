package com.sultandev.feature_category.domain.usecase.impl

import com.sultandev.core_network.di.model.NetworkResponse
import com.sultandev.feature_category.data.model.Categories
import com.sultandev.feature_category.data.model.Category
import com.sultandev.feature_category.domain.repository.CategoryRepository
import com.sultandev.feature_category.domain.usecase.CategoryUseCase

internal class CategoryUseCaseImpl(private val categoryRepository: CategoryRepository) :
    CategoryUseCase {

    override suspend fun invoke(): NetworkResponse<List<Category>> {
        val categoryResponse = categoryRepository.getAllCategory()
        return NetworkResponse(
            isSuccess = categoryResponse.isSuccessful,
            data = categoryResponse.body()?.сategories?.map { it } ?: listOf(),
            error = categoryResponse.message()
        )
    }
}